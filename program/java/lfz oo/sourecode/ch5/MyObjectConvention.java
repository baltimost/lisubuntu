//: MyObjectConvention.java

//package g3ds.joop.ch5;

public class MyObjectConvention{
	public static void main(String[] args){
		MyObject m1 = new MyObject("Ten",10);
		MyObject m2 = new MyObject("Ten",10);
		
		System.out.println("使用关系运算符比较对象");
		System.out.println("m1 == m2 : " + ( m1 == m2 ));
		
		System.out.println("使用使用equals()方法比较对象内容");
		System.out.println("m1.equals(m2) : " + m1.equals(m1));
		
		System.out.println("检测自定义类的散列码：");
		System.out.println("m1.hashCode()="+m1.hashCode());
		System.out.println("m2.hashCode()="+m2.hashCode());
		
		System.out.println(m1.toString());
		System.out.println(m2.toString());
	}
} 

// 自定义一个类
class MyObject {
	//将变量设为私有
  	private int value;
  	private String name;
	
	//利用构造方法参数对变量赋值
	MyObject(String name, int value){
		this.name=name;
		this.value=value;
	}
	
	MyObject(){
		this("Zero",0);
	}
	
	//设计setValue和getValue
	public void setValue(int value){
		this.value=value;
	}
	
	public int getValue(){
		return value;
	}
	
	//设计setName和getName
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}

	//设计equals方法
	public boolean equals(Object obj){
		if  (obj instanceof MyObject){
			return this.value==((MyObject)obj).value &&
				   this.name==((MyObject)obj).name;
		}
		return false;
	}

	//同步设计hashCode方法
	public int hashCode(){
		int hashCode=(new Integer(value).hashCode())^name.hashCode();
		return hashCode;
	}
	
	//覆盖toString方法
	public String toString(){
		String info="MyObject: ";
		info += name + " means the number ";
		info += value;
		
		return info;
	}
}