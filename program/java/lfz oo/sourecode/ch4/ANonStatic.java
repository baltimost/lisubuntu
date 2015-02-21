//: ANonStatic.java

//package g3ds.joop.ch4;

public class ANonStatic{ 
	//声明实例变量
	String a;
	
	//定义实例方法
	void sayHi_A() {
		System.out.println("ANonStatic.sayHi(): ANonStatic's vars are: {" +
			 this.a + ',' + this.b + '}');
	}
	
	//定义构造方法
	public ANonStatic(String aStr, String bStr){
		//测试显式赋值前实例变量a、b的值
		System.out.println("ANonStatic(String aStr, String bStr) at Top: {" + 
			this.a + ',' + this.b + '}');
		
		//为实例变量a、b显式赋值
		a=aStr; 
		b=bStr;
		
		//测试显式赋值后实例变量a、b的值
		System.out.println("ANonStatic(String aStr, String bStr) at Bottom: {" + 
			this.a + ',' + this.b + '}');
	} 
	
	//声明并初始化实例变量
	String b=new BB().sayHi_BB();
	
	//定义实例代码块，执行时相当于把其中的语句按序移入所有的构造方法体中
	{
		System.out.println("ANonStatic.static: ANonStatic's vars are: {" + 
			this.a + ',' + this.b + '}' );
	}
	
	//声明无参构造方法，虽然其中没有显式编写语句，
	//实际上实例代码块中的语句也将移入执行
   	public ANonStatic(){}	
   	
   	public static void main(String[] args) {
   		//测试ANonStatic()中的语句
   		new ANonStatic();
   		//测试ANonStatic(String aStr, String bStr)中的语句
   		new ANonStatic("aaa", "bbb");
		System.out.println("Then execute the clause in ANonStatic's main method.");
	} 
}

class BB {
	//定义静态代码块
	static
	{ 
		ANonStatic instanceA=new ANonStatic();
		System.out.println("BB.nonStatic #1: nonStatic's vars are: {" + 
			instanceA.a + ',' + instanceA.b + '}');
		instanceA.sayHi_A();
		System.out.println("BB.nonStatic #2: ANonStatic's vars are: {" + 
			instanceA.a + ',' + instanceA.b + '}');
	}
	
	//定义实例方法
	String sayHi_BB() {
		System.out.println("In sayHi_BB()");
		return "Hi";
	}
	
	public static void main(String[] args) {} 
}