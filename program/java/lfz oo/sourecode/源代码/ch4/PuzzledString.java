//: PuzzledString.java

//package g3ds.joop.ch4;

public class PuzzledString{
	public static void main(String agrs[]){
		//定义两个内容相同的String型变量，用快速初始化方法创建对象
		String a1="test";
		String b1="test";
		
		//判别这两个变量是否引用同一个对象
		if(a1==b1)
			System.out.println("I think so.");
		else
			System.out.println("So Surprising!");
		
		//定义两个内容相同的String型变量，用new方法创建对象
		String a=new String("test");
		String b=new String("test");

		//判别这两个变量是否引用同一个对象
		if(a==b)
			System.out.println("I think so.");
		else
			System.out.println("So Surprising!");
	}
}