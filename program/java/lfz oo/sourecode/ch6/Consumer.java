//: Consumer.java

//package g3ds.joop.ch6;

//消费者线程
public class Consumer extends Thread { 
	//定义共享资源
	private Soup soup;
	 
	public Consumer(int number) { 
		//...可以在这里进一步定义与顾客有关的信息
	} 
	
	//点菜
	public void order(Soup soup){
		this.soup=soup;
		
		//点完菜理所当然地等着吃啦
		start();
	}
	
	public void run() { 
		for(;;){
			//边吃
			soup.eat(); 
		
			//边谈...
			try { 
				Thread.sleep((int)(Math.random()*2000)); 
			}catch (InterruptedException e) {}  
		}
	}
	
	//测试交互式互斥线程
	public static void main(String args[]) { 
		//创建共享资源
		Soup s = new Soup();
		
		//也可以测试存在多个共享资源对象的情形
		//Soup s1 = new Soup();
		
		//为了使各种可能都显示出来创建多个线程共享资源
		Consumer c1 = new Consumer(5); 
		Consumer c2 = new Consumer(1); 
		Producer p1 = new Producer(1);
		Producer p2 = new Producer(2); 
		
		//分别启动线程
		c1.order(s); 
		c2.order(s); 
		p1.cook(s); 
		p2.cook(s);
	}
}


//生产者线程
class Producer extends Thread { 
	//定义共享资源
	private	Soup soup; 

	public Producer(int number) { 
		//...可以在这里进一步定义与厨师有关的信息
	} 
	
	//开始烹饪
	public void cook(Soup soup){
		//先得知做什么
		this.soup=soup;
		
		//然后开始工作
		start();
	}
	
	public void run() { 
		for(;;){
			//抓紧做
			soup.cook();
			
			//然后喘口气...
			try { 
				Thread.sleep((int)(Math.random() *1000)); 
			}catch (InterruptedException e) {}  
		}
	}
}


//这是共享资源
class Soup { 
	//定义一个控制同步方法的条件变量
	private boolean isReady = false; 
	
	//eat同步方法
	public synchronized void eat(){ 
		//如果菜没有做好就等着吧
		while (!isReady){ 
			try { 
				System.out.println("请稍候，菜马上来——");
				
				wait() ;
			}catch(InterruptedException e){} 			
		} 
		
		/*以下是上菜以后做的情形*/
		
		System.out.println("菜已上齐请慢用！");
		
		//增加延时
		try {
			Thread.sleep((int)(Math.random() *2000));
		}catch(InterruptedException e){}
		
		System.out.println("品尝之中...");
		
		//以下让游戏得以重新开始
		System.out.println("重新点菜...");
		isReady = false; 
		
		//通知其它线程
		notifyAll(); 
	} 
	
	//cook同步方法
	public synchronized void cook() { 
		//如果菜都做好就歇着吧
		while (isReady){
			try{ 
				System.out.println("菜都已做好——");
				
				wait();
			}catch(InterruptedException e) {} 
		} 
		
		/*以下是做菜的情形*/
		
		System.out.println("烹饪之中...");
		
		//增加延时
		try{
			Thread.sleep((int)(Math.random() *2000));
		}catch(InterruptedException e){} 
		
		System.out.println("菜来啦！");

		//改变条件值
		isReady = true; 
		
		//通知其它线程
		notifyAll(); 
	} 
}