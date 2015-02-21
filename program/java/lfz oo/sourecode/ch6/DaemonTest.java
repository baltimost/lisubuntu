//: DaemonTest.java

//package g3ds.joop.ch6;

public class DaemonTest{
	public static void main(String[] args){
		//创建一个守护线程
		Thread d = new DaemonThread();
		
		//可以通过输入任意参数改变守护线程为用户线程
		if(args.length>0){
			//注意！这一步必须在线程启动前执行，否则运行时引发
			//异常：java.lang.IllegalThreadStateException
			d.setDaemon(false);
		}
		
		//启动线程	
		d.start();
		
		//检测当前实例是否为守护线程 
		System.out.println("d.isDaemon() = " + d.isDaemon());
	}
}

class DaemonThread extends Thread {
	//设定子线程数目
	private static final int SIZE = 10;
	private Thread[] t = new Thread[SIZE];
	
	public DaemonThread() { 
		//缺省状态所有实例都是守护线程
		setDaemon(true);
	}
	
	public void run() {	
		//如果当前实例是守护线程的附加输出内容	
		if(isDaemon())
			System.out.println("守护线程中的子线程自动设为守护线程：");	
		else
			System.out.println("用户线程中的子线程性质不变：");	
			
		for(int i = 0; i < SIZE; i++){
			//创建当前实例的子线程，使用this关键字
			t[i] = this.new DaemonSpawn(i);
		
			//检测当前实例的子线程是否为守护线程	
			System.out.println("t[" + i +
				"].isDaemon() = " + t[i].isDaemon());
		}
		
		//使用yield方法让出CPU控制权
		if(isDaemon()){
			//作为守护线程，在后台保持运行状态，因此用无限循环
			while(true) 
				yield();
		}
		else
			yield();
	}
	
	//设计当前类的子线程类，并没有设置其为守护线程
	private class DaemonSpawn extends Thread {
		DaemonSpawn(int i) {
			System.out.println("DaemonSpawn " + i + " started");
			
			//启动线程
			start();
		}
	
		public void run() {
			//使用yield方法让出CPU控制权
			if(isDaemon()){
				//作为守护线程，在后台保持运行状态，因此用无限循环
				while(true) 
					yield();
			}
			else
				yield();
		}
	}
}