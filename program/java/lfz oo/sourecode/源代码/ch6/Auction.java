//： Auction.java

//package g3ds.joop.ch6;

public class Auction{
	public static void main(String[] args){
		//给定条件相同，利用BidThread类直接创建2个线程的做法
		BidThread p1=new BidThread(10, 1000);
		BidThread p2=new BidThread(10, 1000);
		
		//设定线程名称，便于观察：看谁跑得快！
		p1.setName("猎豹");
		p2.setName("瞪羚");

		//创建BidRun类的2个实例，给定条件相同
		BidRun r1=new BidRun(10, 1000);
		BidRun r2=new BidRun(10, 1000);
		BidRun r3=new BidRun(10, 1000);
		BidRun r4=new BidRun(10, 1000);
		
		//设定类实例的名称，便于观察：看谁跑得快！
		r3.setName("角马");
		r4.setName("狮子");
		
		//利用以上的BidRun类的2个实例对象间接创建线程的做法
		Thread p3=new Thread(r3);
		Thread p4=new Thread(r4);
		
		//启动线程
		p1.start();
		p2.start();
		p3.start();
		p4.start();	
		
		//这一段会使主线程一直等待子线程结束后才继续后面的语句
		try{
			p1.join();
			p2.join();
			p3.join();
			p4.join();
		}
		catch(InterruptedException e){}
		
		//主线程并不需要等待方法体中的子线程执行完毕才继续后面的语句，
		//这也验证了线程并发性的概念。
		System.out.println("线程均启动，主线程的语句执行完毕！");
	}
}