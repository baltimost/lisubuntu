//: PropertyDemo.java

//package g3ds.joop.ch5;

public class PropertyDemo{
	public static void main(String[] Args){
		System.out.println("操作系统："+System.getProperty("os.name"));
		System.out.println("用户名："+System.getProperty("user.name"));
		System.out.print("Java虚拟机: "+System.getProperty("java.vm.name"));
		System.out.println(" "+System.getProperty("java.vm.version"));
		System.out.println("Java提供商："+System.getProperty("java.vendor"));
	}
}