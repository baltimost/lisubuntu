//: AStatic.java

//package g3ds.joop.ch4;

public class AStatic { 
	//定义类变量
	static String a = "aaa";
	static String b = new B().sayHi_B();
	
	//定义静态代码块 
	static { 
		System.out.println("AStatic.static: AStatic's vars are: {" + AStatic.a + ',' + AStatic.b + '}' );
   	} 
   	
   	//定义实例方法
	void sayHi_AStatic() {
		System.out.println("AStatic.sayHi(): AStatic's vars are: {" + AStatic.a + ',' + AStatic.b + '}'); 
	}
	
	public static void main(String[] args) {
		//main方法中的语句在初始化后执行
		System.out.println("Then execute the clause in AStatic's main method.");
	} 
} 

class B{
	//定义静态代码块
	static{ 
		System.out.println("B.static #1: AStatic's vars are: {" + AStatic.a + ',' + AStatic.b + '}'); 
		new AStatic().sayHi_AStatic();
		System.out.println("B.static #2: AStatic's vars are: {" + AStatic.a + ',' + AStatic.b + '}');
	} 
	
	//定义实例方法
	String sayHi_B() {
		return "Hi";
	} 
	
    public static void main(String[] agrs) { }
}

/*	执行java AStatic 和java B时初始化过程的正确答案分别是
1. 	B.static #1: AStatic's vars are: {aaa,null}
 	AStatic.sayHi(): AStatic's vars are: {aaa,null}
	B.static #2: AStatic's vars are: {aaa,null} 
	AStatic.static: AStatic's vars are: {aaa,Hi}
2. 	AStatic.static: AStatic's vars are: {aaa,Hi}
	B.static #1: AStatic's vars are: {aaa,Hi}
	AStatic.sayHi(): AStatic's vars are: {aaa,Hi}
	B.static #2: AStatic's vars are: {aaa,Hi} 
3. 	AStatic.static: AStatic's vars are: {aaa,null}
	B.static #1: AStatic's vars are: {aaa,null}
	AStatic.sayHi(): AStatic's vars are: {aaa,null}
	B.static #2: AStatic's vars are: {aaa,null}
4. 	B.static #1: AStatic's vars are: {aaa,null} 
	AStatic.sayHi(): AStatic's vars are: {aaa,Hi}
	B.static #2: AStatic's vars are: {aaa,Hi}
	AStatic.static: AStatic's vars are: {aaa,Hi} 
*/