//: Customer.java

//package g3ds.joop.ch6;

import java.util.*;

//这是一个共享资源类
public class Customer{
	//对顾客编号
	private int number;
	
	public Customer(int number){
		this.number=number;
	}
	
	//模拟某位顾客需要服务
	public void call(){
		System.out.println(getNumber() + " 号客人：服务生——");
		
		//则该位顾客进入待服务清单
		Waiter.list(this);	
	}
	
	//获得顾客编号信息
	public int getNumber(){
		return number;
	}
	
	//测试互斥线程
	public static void main(String[] args){
		//创建多个顾客，并且不连续启动线程，使之更具一般性
		Customer c1=new Customer(1);
		Customer c2=new Customer(2);	
		Customer c3=new Customer(3);
		
		c1.call();
			
		//假设只有2个服务生
		Waiter w1=new Waiter("服务生甲->");
		Waiter w2=new Waiter("服务生乙");
		
		w1.start();
			
		c2.call();
		c3.call();
		
		new Customer(4).call();
		
		c2.call();
		w2.start();
	}
}


//设计服务生为线程类
class Waiter extends Thread{
	//提供清单中待服务顾客的索引号
	private volatile static int index;
	//记录需要服务顾客总数
	private static int total;
	//创建一个ArrayList集合，该类在java.util包中
	private static List customers=new ArrayList();
	
	//这是为整个类提供一个对象锁的变量
	private static Object obj=new Object();
	
	Waiter(String name){
		//把名称传给线程
		super(name);
	}
	
	//重写run方法
	public void run(){
		//开始上班提供服务
		serve();
	}
	
	//设计具体的服务操作
	void serve(){
		Customer c=null;
		
		//上班时间如果有客人需要服务，服务生不能闲着！
		while(true){
			/*同步代码块，用来为所有的服务生调度具体的服务对象*/
			synchronized(obj){
				//如果没有需求就歇着吧
				if(index>=total) break;
						
				//否则就按顺序为顾客服务
				c=(Customer)(customers.get(index));
				
				try{
					Thread.sleep(1000);	
				}catch(InterruptedException e){}
				
				index++;
			}
			
			/*以下为情景设计*/
								
			String str ="正在为 " + c.getNumber() + " 号客人";
			String waiter = getName();
			
			System.out.println(waiter + str + "服务。");
			
			//主动让出CPU
			Thread.yield();
			
			System.out.println(waiter + str + "上菜...");
				
			System.out.println(waiter + str + "斟酒...");
			
			//主动让出CPU	
			Thread.yield();
		}
	}
	
	//设计登记需要服务的顾客
	static void list(Customer customer){
		System.out.println("哎，马上就来——");
		
		customers.add(customer);
			
		total++;
	}
}