//: UsingMyException.java

//package g3ds.joop.ch5;

public class UsingMyException{
	//定义方法时必须用throws声明对该异常不处理
	public void f()  throws MyException{
		//在此处引发一个异常
		throw new MyException("Throwing MyException from f()");
	}
	
	//调用抛出异常的方法，如果不想处理同样要用throws声明
	public void g() throws MyException {
		//引发异常的方法
		f();
	}
	
	public static void main(String[] args){
		//调用抛出异常的方法，并捕获处理
		try {
			new UsingMyException().g();
		} 
		catch(MyException e) {
			System.out.println(e.getMessage());
		}
	
		System.out.println("继续其后的操作...");
	} 
}

//定制自己的异常类
class MyException extends Exception {
	public MyException() {}
	
	public MyException(String msg) {
		//调用父类构造方法，传递msg，
		//以便在Throwable.getMessage()方法显示
		super(msg);
	}
}