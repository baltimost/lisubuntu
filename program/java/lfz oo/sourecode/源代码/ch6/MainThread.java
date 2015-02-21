//: MainThread.java 

//package g3ds.joop.ch6;

public class MainThread { 
	public static void main(String[] args) { 
		//声明一个线程类型变量引用当前的活动线程对象
		Thread t=Thread.currentThread(); 
		
		//把当前线程命名为“主线程”，因为我们并没有显式创建过线程
		t.setName("主线程");
		
		//输出当前线程信息
		System.out.println("正在运行的线程：" + t); 
	} 
}