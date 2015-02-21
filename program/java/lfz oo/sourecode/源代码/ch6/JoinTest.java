//: JoinTest.java

//package g3ds.joop.ch6;

public class JoinTest{
	public static void main(String[] args){
		//创建外部类实例
		JoinTest obj=new JoinTest();
		
		//创建内部类线程实例并启动之
		MyThread p1 = obj.new MyThread("张三");
		MyThread p2 = obj.new MyThread("李四");
		MyThread p3 = obj.new MyThread("王老五");
		
		//主线程等待子线程执行完毕返回后继续其后的操作
		try{
			p1.join();
			p2.join();
			p3.join();
		}catch(InterruptedException e){}
		
		System.out.println("主线程的语句执行完毕！");
	}
	
	//设计一个扩展Thread的内部类
	private class MyThread extends Thread{
		//设计传递实例名的构造方法
		MyThread(String name){
			super(name);
			
			//并启动线程
			start();
		}
		
		//覆盖父类的run方法
		public void run(){
			try{
				Thread.sleep(100);
				
				System.out.println(this.toString() + "执行完毕！");
			}
			catch(InterruptedException e){}
		}
	}
}