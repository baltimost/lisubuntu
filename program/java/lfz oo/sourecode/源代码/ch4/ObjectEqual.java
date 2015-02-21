//: ObjectEqual.java

//package g3ds.joop.ch4;

public class ObjectEqual{
	public static void main(String[] args) {
		Integer n1 = new Integer(100);
		Integer n2 = new Integer(100);
		MyInt m1 = new MyInt();
		MyInt m2 = new MyInt();
		m1.value = 100;
		m2.value = 100;

		// 使用==进行对象的比较，显然二者都为false
		System.out.println("使用关系运算符比较对象");
		System.out.println("n1 == n2 : " + ( n1 == n2 ));
		System.out.println("m1 == m2 : " + ( m1 == m2 ));
		
		// 使用equals()方法进行比较，调用Integer类改写的方法
		System.out.println("调用equals()方法时");
		System.out.println("Integer类—n1.equals(n2) : " + n1.equals(n2));
		
		// 使用equals()方法对自定义对象的进行比较，实际上是调用Object类的方法
		System.out.println("MyInt类—m1.equals(m2) : " + m1.equals(m2));
	}
} 

class MyInt {
  int value;
}

