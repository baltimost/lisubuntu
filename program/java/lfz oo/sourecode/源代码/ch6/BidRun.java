//: BidRun.java

//package g3ds.joop.ch6;

public class BidRun implements Runnable {
	//记录每次的竞价
	int finalBid;
	
	//竞价的增量值
	int increment;
	
	//每次竞价的延时（毫秒）
	int delayTime;
	
	//设置实例名称
	private String name;
	
	BidRun(int increment, int delayTime) {
		this.increment = increment;
		this.delayTime = increment;
		
		//如果没有为实例命名，toString方法依然返回散列码
		this.name=Integer.toHexString(this.hashCode());
	}
	
	//实现接口Runnable的run方法
	public void run() {
		try{
			for(int i=0; i<100; i++){
				finalBid += increment;
				System.out.println(toString() + " BID: " + finalBid);
				
				//Thread.currentThread()方法返回当前运行的线程，并调用相应方法
				//举sleep方法只是为了方便，实际上静态方法可直接用类名调用。
				Thread t = Thread.currentThread();
				t.sleep(delayTime);
			}
		}
		catch(InterruptedException e){
			return;
		}
	}
	
	//提供为实例命名的方法
	void setName(String name){
		this.name=name;
	}
	
	//覆盖toString方法
	public String toString(){
		return "Thread[" + name + ",      ]";
	}
	
	//测试实现Runnable接口的类创建线程
	public static void main(String[] args){
		//创建实例，给定条件相同
		BidRun r1=new BidRun(10, 1000);
		BidRun r2=new BidRun(10, 1000);
		BidRun r3=new BidRun(10, 1000);
		BidRun r4=new BidRun(10, 1000);
		
		//设定类实例的名称，便于观察：看谁跑得快！
		r1.setName("猎豹");
		r2.setName("瞪羚");
		r3.setName("角马");
		r4.setName("狮子");
		
		//将以上的对象传递给线程
		Thread p1=new Thread(r1);
		Thread p2=new Thread(r2);
		Thread p3=new Thread(r3);
		Thread p4=new Thread(r4);
		
		//启动线程
		p1.start();
		p2.start();
		p3.start();
		p4.start();	
	}
}