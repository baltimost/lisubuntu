//: ReferenceConversion

//package g3ds.joop.ch3;

public class ReferenceConversion{
	public static void main(String[] args){
		ReferenceChild child=new ReferenceChild();
		//声明为父类而由子类实现，可以自动转换
		ReferenceParent parent=child;
		//这时调用父子类中的同名方法因多态性而调用子类方法
		parent.show();
		//但是对于同名的属性则是调用父类的属性，这或许不是我们想要的
		System.out.println(parent.str);	
		//若要调用子类的同名属性则要做强制类型转换，即把父类变量转换为子类
		System.out.println(((ReferenceChild)parent).str);
	}	
}

class ReferenceParent{
	String str="ReferenceParent's Attribute";
	protected void show(){
		System.out.println("ReferenceParent's Method");
	}
}

class ReferenceChild extends ReferenceParent{
	String str="ReferenceChild's Attribute";
	protected void show(){
		System.out.println("ReferenceChild's Method");
	}
}