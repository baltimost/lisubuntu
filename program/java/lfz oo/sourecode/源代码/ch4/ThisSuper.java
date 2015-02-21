//: ThisSuper.java

//package g3ds.joop.ch4;

public class ThisSuper{
	public static void main(String[] args){
		ThisExample obj=new ThisExample(10);
		System.out.println(obj.toString()+ ": obj.aValue="+obj.aValue);
		//可以利用类型转换获得父类的同名变量：((SuperExample)obj).aValue
		//而不是采用这种形式：obj.super.aValue
		System.out.println("((SuperExample)obj).aValue="+((SuperExample)obj).aValue);
	}
}

class SuperExample{
	int aValue;
	public SuperExample(){
		aValue=10;
	}
}

class ThisExample extends SuperExample{
	int aValue;
	public ThisExample(int otherValue){
		//利用super显式调用父类构造方法SuperExample()
		//事实上这是缺省语句，不写也可以
		//这种语句只能在构造方法中使用
		super();
		//利用super调用父类变量
		aValue=super.aValue*otherValue; 
	}
	
	public ThisExample(){
		//利用this显式调用构造方法 ThisExample(int aValue)
		//这种语句只能在构造方法中使用
		this(0);
	}
	
	public void setValue(int aValue){
		//利用this调用与局部变量同名的实例变量
		this.aValue=aValue;
	}
}