//: YieldTest.java

//package g3ds.joop.ch6;

public class YieldTest{
	public static void main(String[] args){
		//创建外部类实例
		YieldTest obj=new YieldTest();
		
		//创建内部类线程实例并启动之
		MyThread p1 = obj.new MyThread("张三");
		MyThread p2 = obj.new MyThread("李四");
		MyThread p3 = obj.new MyThread("王老五");
	}
	
	//设计一个扩展Thread的内部类
	private class MyThread extends Thread{
		//设计传递实例名的构造方法
		MyThread(String name){
			super(name);
			
			// 并启动线程
			start();
		}
		
		//覆盖父类的run方法
		public void run(){
			for(int i=0; i<5; i++){
				System.out.println(toString() + ": " + i);
				
				//主动把当前线程的权限让出，请比较用与不用下面语句的差别
				Thread.yield();
			}
		}
	}
}