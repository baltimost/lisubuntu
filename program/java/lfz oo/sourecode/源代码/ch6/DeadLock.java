// DeadLock.java

//package g3ds.joop.ch6;


public class DeadLock implements Runnable{
	AssociatedClassA a = new AssociatedClassA();
	AssociatedClassB b = new AssociatedClassB();

	DeadLock() {
		Thread.currentThread().setName("Thread1");
		Thread t = new Thread(this, "Thread2");
		t.start();

		//由当前线程获得a对象锁
		a.foo(b);
		System.out.println("Back in main thread");
	}

	public void run() {
		//由其它线程获得b对象锁
		b.bar(a); 
		System.out.println("Back in other thread");
	}

	public static void main(String args[]) {
		new DeadLock();
	}
}


//相关联的类设计
class AssociatedClassA{
	//设计相关联的同步方法
	synchronized void foo(AssociatedClassB b) {
		String name = Thread.currentThread().getName();

		System.out.println(name + "::执行AssociatedClassA类的foo方法");

		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {}

		System.out.println(name + "::试图执行AssociatedClassB类的last方法");
		
		//调用关联类的同步方法
		b.last();
	}
	
	//在关联类中被调用的同步方法，实际上发生死锁
	synchronized void last() {
		System.out.println("Inside AssociatedClassA.last");
	}
}


//相关联的类设计
class AssociatedClassB{
	//设计相关联的同步方法
	synchronized void bar(AssociatedClassA a) {
		String name = Thread.currentThread().getName();
		
		System.out.println(name + "::执行AssociatedClassB类的bar方法");

		try {
			Thread.sleep(1000);
    	} catch(InterruptedException e) {}

		System.out.println(name + "::试图执行AssociatedClassA类的last方法");
		
		//调用关联类的同步方法
		a.last();
	}
	
	//在关联类中被调用的同步方法，实际上发生死锁
	synchronized void last() {
		System.out.println("Inside AssociatedClassA.last");
	}
}