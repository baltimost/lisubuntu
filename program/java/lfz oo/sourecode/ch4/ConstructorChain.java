//: ConstructorChain.java

//package g3ds.joop.ch4;

public class ConstructorChain{
	public static void main(String[] args){
		ThisClass obj=new ThisClass(80);
		System.out.println("ThisClass实例对象中aValue的值为："+obj.aValue);
	}
}

class SuperSuperClass{
	//声明实例变量
	protected int aValue;
	
	SuperSuperClass(int aValue){
		//隐式调用父类的无参数构造方法super()，就本例而言为Object()
		System.out.println("实例变量aValue的缺省初始值为："+ this.aValue);
		this.aValue=aValue;
		System.out.println("SuperSuperClass构造方法中为aValue赋值："+ aValue);
	}
	
	/*
	  如果没有定义此无参数构造方法，则其扩展类SuperClass构造方法
	  将无法完成构造方法链调用，引发如下的错误：
		cannot resolve symbol symbol  : constructor SuperSuperClass()
	*/
	SuperSuperClass(){
		//显式调用本类的其它构造方法
		this(10);
	}
}

class SuperClass extends SuperSuperClass{
	SuperClass(int aValue){
		//隐式调用父类的无参数构造方法super()，就本例而言为SuperSuperClass()
		System.out.println("继承自SuperSuperClass类的aValue值："+ this.aValue);
		this.aValue=aValue;
		System.out.println("SuperClass构造方法中为aValue赋值："+ this.aValue);
	}
	
	/*
	  因为已经定义了带参数的构造方法，所以原来缺省的无参数构造方法SuperClass()
	  将自动失效，如果要使用它必须再显式定义。
	  虽然从本例看这个构造方法是没有用的，但如果这是您设计供用户使用的类，那么
	  缺少这个构造方法将是危险的，因为当用户扩展您的类时有可能就隐式调用了无参
	  数构造方法，这样将引发不必要的错误，除非您定义的是一个final类。作为一种
	  好的习惯，最好显式定义无参数的构造方法。
	*/
	SuperClass(){
		//显式调用本类的其它构造方法
		this(50);
	}
}

final class ThisClass extends SuperClass{
	ThisClass(int aValue){
		//显式调用父类带参数的构造方法
		super(aValue);
	}
	
	//fianl类不能再被扩展，不包含无参数构造方法也不会带来麻烦，
	//如果它真的没有用的话。
	//ThisClass(){}
}