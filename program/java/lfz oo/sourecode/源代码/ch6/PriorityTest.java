//: PriorityTest.java

//package g3ds.joop.ch6;

public class PriorityTest{
	public static void main(String[] args){
		//把主线程的优先级设为最高
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		
		//创建2个优先级不一样的线程
		Counter hi = new Counter(Thread.NORM_PRIORITY + 2);
		Counter lo = new Counter(Thread.NORM_PRIORITY - 2);
		
		//启动线程
		lo.start();
		hi.start();
		
		//主线程暂停，使得子线程有时间执行
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}

		//改变循环条件，使得子线程结束
		lo.stop();
		hi.stop();

		//等待子线程结束
		try {
			hi.t.join();
			lo.t.join();
		} catch (InterruptedException e) {}

		//分别输出优先级不同的子线程记数值
		System.out.println("Low-priority thread: " + lo.count); 
		System.out.println("High-priority thread: " + hi.count);
	}
}

class Counter implements Runnable {
	int count = 0;
	Thread t;
	
	//设置计数循环条件变量，volatile关键字使得每次循环都要重新读变量值
	private volatile boolean running = true;

	public Counter(int p) {
		//间接创建线程
		t = new Thread(this);
		
		//设置线程优先级
		t.setPriority(p);
	}

	public void run() {
		//一直累加计数，直到条件改变
		while (running) {
			count++;
		}
	}

	//提供改变循环条件的方法
	public void stop() {
		running = false;
	}
	
	//启动线程的方法
	public void start() {
		t.start();
	}
}