//: ClassExample.java

//package g3ds.joop.ch3;

public class ClassExample{
	// 声明成员属性，可以是静态的或非静态的
	int i;
	static int j;
	
	// 静态初始化语句块
	static{
		j=10;
		System.out.println("In static initializer.");
	}
	
	// 实例初始化语句块
	{
		i=10;
		System.out.println("In instance initializer.");
	}
	
	// 构造方法
	public ClassExample(){
		System.out.println("In constructor.");
	}
	
	// 内嵌类，可以是静态的或非静态的
	static class NestedClass implements InnerInterface{
		public void f(){}
	}
	
	// 内嵌接口，无论显式或隐式声明都是静态的
	interface InnerInterface{void f();}

	// 定义成员方法，可以是静态的或非静态的
	public static void main(String[] args){
		new ClassExample();
	}
}
