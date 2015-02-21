//: BidThread.java

//package g3ds.joop.ch6;

public class BidThread extends Thread {
	//记录每次的竞价
	int finalBid;
	
	//竞价的增量值
	int increment;
	
	//每次竞价的延时（毫秒）
	int delayTime;
	
	BidThread(int increment, int delayTime) {
		this.increment = increment;
		this.delayTime = increment;
	}
	
	//覆盖父类的run方法
	public void run() {
		try{
			for(int i=0; i<100; i++){
				finalBid += increment;
				System.out.println(toString() + " BID: " + finalBid);
				Thread.sleep(delayTime);
			}
		}
		catch(InterruptedException e){
			return;
		}
	}
	
	//测试用Thread类扩展的线程子类
	public static void main(String[] args){
		//创建线程，给定条件相同
		BidThread p1=new BidThread(10, 1000);
		BidThread p2=new BidThread(10, 1000);
		BidThread p3=new BidThread(10, 1000);
		BidThread p4=new BidThread(10, 1000);
		
		//设定线程名称，便于观察：看谁跑得快！
		p1.setName("猎豹");
		p2.setName("瞪羚");
		p3.setName("角马");
		p4.setName("狮子");
		
		//启动线程
		p1.start();
		p2.start();
		p3.start();
		p4.start();	
	}
}