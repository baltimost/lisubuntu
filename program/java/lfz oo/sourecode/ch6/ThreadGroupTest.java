//: ThreadGroupTest.java

//package g3ds.joop.ch6;

public class ThreadGroupTest{
	public static void main(String[] args){
		Thread t = Thread.currentThread();
		
		System.out.println(t.toString() + ": " + 
							t.getThreadGroup().getName());
	}
}