//: ThreadSharedData.java

//package g3ds.joop.ch6;

public class ThreadSharedData implements Runnable{
	//实例变量之于线程是共享的
	int sharedValue=100;
	
	public void run(){
		//局部变量之于线程则是独立的
		int nonSharedValue=0;
		
		//改变变量值
		sharedValue +=100;
		nonSharedValue +=100;
		
		//并显示		
		System.out.println("SharedValue= " + sharedValue);
		System.out.println("NonSharedValue= " + nonSharedValue);
		
		//调用其它方法
		doSomething();
	}
	
	public void doSomething(){
		//局部变量之于线程则是独立的
		int nonSharedValue=0;
		
		//改变变量值
		nonSharedValue +=100;
		sharedValue +=100;
		
		//并显示 	
		System.out.println("SharedValue(inMethod)= " + sharedValue);
		System.out.println("NonSharedValue(inMethod)= " + nonSharedValue);	
	}
	
	//测试
	public static void main(String[] args){
		ThreadSharedData t=new ThreadSharedData();
		
		for(int i=0; i<2; i++){
			new Thread(t).start();
		}
	}
}