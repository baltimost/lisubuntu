//: StringExample.java

//package g3ds.joop.ch3;

public class StringExample{
	public static void main(String[] args) {
		//字符串快速创建方式，直接访问字符串常量池
		String hello = "Hello", lo = "lo";
		
		System.out.println("使用字符串常量池中对象的情况：");
		//同一个类中快速创建的字符串引用池中同一对象
		System.out.print((hello == "Hello") + " ");
		//同一个包中快速创建的字符串引用池中同一对象
		System.out.print((Other.hello == hello) + " ");
		//不同包中快速创建的字符串引用池中同一对象
		System.out.print((g3ds.joop.ch3.otherPackage.StringCase.hello == hello) + " ");
		//快速创建的字符串连接在编译时即计算为一个字符串，也引用池中同一对象
		System.out.print((hello == ("Hel"+"lo")) + " ");
		//String.intern()方法可以引用池中与当前字符串内容相同的String对象
		System.out.println(hello == ("Hel"+lo).intern());
		
		System.out.println("不是使用字符串常量池中对象的情况：");		
		//用常规new创建字符串对象，不引用池中相应的对象
		String helloNew=new String("hello");
		System.out.print((hello == helloNew) + " ");
		//快速创建的字符串与字符串变量连接，其结果在运行时计算，等同于用new创建
		System.out.println((hello == ("Hel"+lo)) + " ");
		
		System.out.println("字符串内容不可被改变的例子：");
		//声明helloCopy引用池中字符串"hello"对象
		String helloCopy = hello;
		System.out.println("改变hello内容之前helloCopy的内容："+helloCopy);
		//改变hello的内容
		hello="Hello World";
		//如果是池中字符串对象的内容被改变，则helloCopy的内容也应跟着改变，实际并非如此
		System.out.println("改变hello内容之后helloCopy的内容："+helloCopy);
		//可以再声明一个变量helloWorld引用池中字符串"Hello World"对象，其引用与hello相同
		String helloWorld="Hello World";
		System.out.println("在池中创建一个新的对象："+(hello==helloWorld));
		//一种更像更改String对象内容的写法如下，实际上也是创建一个新的对象
		helloCopy+=" World";
		System.out.println("运行时运算创建一个新的对象，不从池中引用："+(helloCopy!=helloWorld));
	}
}

class Other { 
	//如果在同一个JVM中调用快速创建的String对象，都从一个池中引用
	static String hello = "Hello"; 
}