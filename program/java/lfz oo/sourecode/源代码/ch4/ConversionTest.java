//: ConversionTest.java

//package g3ds.joop.ch4;

class Super{
	static String str1="超类的静态变量";
	String str2="超类的实例变量";
	
	static void showStatic(){
		System.out.println("超类的静态方法");
	}
	
	void showNonStatic(){
		System.out.println("超类的实例方法");
	}
}

class This extends Super{
	//定义与超类重名的静态变量
	static String str1="子类的静态变量";
	
	//定义与超类重名的实例变量
	String str2="子类的实例变量";
	
	//当改写超类的静态方法时，在当前类中也必须设计为静态的，否则报错！
	static void showStatic(){
		System.out.println("子类的静态方法");
	}
	
	//改写超类的实例方法
	void showNonStatic(){
		System.out.println("子类的实例方法");
	}
	
	//添加子类特有的成员变量，可以是静态的或者非静态的
	static String str3="子类特有成员变量";
	
	//添加子类特有的成员方法，可以是静态的或者非静态的
	void showDetail(){
		System.out.println("子类特有的成员方法");
	}
}

public class ConversionTest{
	public static void main(String arg[]){
		//测试：以超类声明以子类实例化，存在转型
		Super obj=new This();
		
		//对静态和非静态成员的多态机制测试
		System.out.println(obj.str1);
		System.out.println(obj.str2);
		obj.showStatic();
		obj.showNonStatic();
		
		//以下是对子类特有成员的测试
		
		//以下两句将报错：cannot resolve symbol
		//System.out.println(obj.str3);
		//obj.showDetail();
		
		//以下两句做了窄化转换处理，可以执行
		System.out.println(((This)obj).str3);
		((This)obj).showDetail();
	}
}