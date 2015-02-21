//: AssertionExample.java

//package g3ds.joop.ch5;

public class AssertionExample{
	public static void main(String[] args){
		int age=Integer.parseInt(args[0]);
		System.out.println("您输入的数字："+age);
		
		//断言语句检测
		assert age>0: "输入年龄有误（非正）！";
		
		//如果检测通过，将继续以下程序段
		System.out.println("您的实际年龄是："+age+"岁——祝您健康长寿！");
	}
}