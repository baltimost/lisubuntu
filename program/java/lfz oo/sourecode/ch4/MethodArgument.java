//: MethodArgument.java

//package g3ds.joop.ch4;

public class MethodArgument{
	public static void main(String[] args){
		int length=10;
		StringBuffer str=new StringBuffer("Contents");
		
		MethodArgument obj=new MethodArgument();
		System.out.println("作为参数传递之前int型变量length的值为："+length);
		obj.passByValue(length);
		System.out.println("作为参数传递之后int型变量length的值为："+length);
		
		System.out.println("作为参数传递之前StringBuffer型变量str的值为："+str);
		obj.passByReference(str);
		System.out.println("作为参数传递之后StringBuffer型变量str的值为："+str);
	}
	
	void passByValue(int length){
		length *=length;
		System.out.println("方法体中int型变量length的值改变为："+length);
	}
	
	void passByReference(StringBuffer str){
		str.append(" Changed!");
		System.out.println("方法体中StringBuffer型变量str的值改变为："+str);
	}
}