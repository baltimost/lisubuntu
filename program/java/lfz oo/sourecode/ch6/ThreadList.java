//: ThreadList.java

//package g3ds.joop.ch6;

public class ThreadList{
	public static void main(String[] args) {
		//创建外部类实例
		ThreadList obj=new ThreadList();
		
		//创建内部类线程实例并启动之
		obj.new MyThread("张三").start();
		obj.new MyThread("李四").start();
		obj.new MyThread("王老五").start();

		/*
		//如果加上以下语句块，则以上线程可能都执行完并被清除
		try{
			Thread.sleep(200);
			System.gc();
		}catch(InterruptedException e){}
		*/
		
		//列出已启动且未被清除的线程名
		showThreads();
	}
	
	//设计一个扩展Thread的内部类
	private class MyThread extends Thread{
		//设计传递实例名的构造方法
		MyThread(String name){
			super(name);
		}
		
		//覆盖父类的run方法
		public void run(){
			try{
				//System.out.println(toString()+": "+getThreadGroup().getName());
				
				Thread.sleep(100);
			}
			catch(InterruptedException e){}
		}
	}
	
	//获取程序中所有线程列表的方法
	public static void showThreads(){
		Thread[] t=new Thread[Thread.activeCount()];
		
		int count=Thread.enumerate(t);
		
		System.out.println("已启动的线程：");
		for(int i=0; i<count; i++)
			System.out.print(t[i].getName()+ "\t");
		System.out.println();
	}
}