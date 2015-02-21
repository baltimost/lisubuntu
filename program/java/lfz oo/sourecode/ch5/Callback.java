//: Callback.java

//package g3ds.joop.ch5;

//定义一个接口，其中承诺有一个run方法
interface MyInterface{
	void run();
}

//定义一个抽象类，其中承诺有一个runAlso方法
abstract class MyAbstract{
	public abstract void runAlso();
}

//用户可以通过自己的代码调用这些抽象方法，尽管此时根本没有实现这个接口或抽象类
class UserClass{
	//用接口声明引用类型
	void doSomething(MyInterface obj){
		obj.run();
	}
	
	//用抽象类声明引用类型
	void doAlso(MyAbstract obj){
		obj.runAlso();
	}
}

//提供一个类，继承MyAbstract类，实现MyInterface接口
class MyClass extends MyAbstract implements MyInterface{
	void run(){
		System.out.println("恭贺新禧！");
	}
	
	public void runAlso(){
		System.out.println("恭喜发财！");
	}
}


public class Callback{
	public static void main(String[] args){
		MyClass myObj=new MyClass();
		UserClass userObj=new UserClass();
		
		//把一个MyClass对象传递给UserClass对象的相应方法
		userObj.doSomething(myObj);
		userObj.doAlso(myObj);
	}
}