//: MemberInit.java
//: 例子原型引用自Bruce Eckel之"Thinking in Java"

// package g3ds.joop.ch4;

public class MemberInit{
	//main方法在类被加载以后调用并执行之
	public static void main(String[] args) {
		System.out.println("在main方法中创建Cupboard对象 ");
		new Cupboard();
		
		System.out.println("在main方法中再创建Cupboard对象");
		new Cupboard();
		
		t2.f2(1);
		t3.f3(1);
	}
	
	//定义静态变量，在加载类时初始化
	static Table t2 = new Table();
	static Cupboard t3 = new Cupboard();
} 

class Bowl {
	//构造方法
	Bowl(int marker) {
		System.out.println("Bowl(" + marker + ")");
	}
	
	//实例方法
	void f(int marker) {
		System.out.println("f(" + marker + ")");
	}
}

class Table {
	//定义静态变量，在加载类时初始化
	static Bowl b1 = new Bowl(1);
	
	//构造方法
	Table() {
		System.out.println("Table()");
		
		//调用Bowl的实例方法
		b2.f(1);
	}
	
	void f2(int marker) {
		System.out.println("f2(" + marker + ")");
	}
	
	//定义静态变量，在加载类时初始化
	static Bowl b2 = new Bowl(2);
}

class Cupboard {
	//定义实例变量，只有创建实例时才进行初始化
	Bowl b3 = new Bowl(3);
	
	//定义静态变量，在加载类时初始化
	static Bowl b4 = new Bowl(4);
	
	Cupboard() {
		System.out.println("Cupboard()");
		
		//调用Bowl的实例方法
		b4.f(2);
	}
	
	void f3(int marker) {
		System.out.println("f3(" + marker + ")");
	}
	
	//定义静态变量，在加载类时初始化
	static Bowl b5 = new Bowl(5);
}