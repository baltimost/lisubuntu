//: StringCase.java

package g3ds.joop.ch3.otherPackage;

public class StringCase{ 
	//如果在同一个JVM中调用快速创建的String对象，都从一个池中引用
	public static String hello = "Hello"; 
}
