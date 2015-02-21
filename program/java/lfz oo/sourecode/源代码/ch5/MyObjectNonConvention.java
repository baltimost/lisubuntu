//: MyObjectNonConvention.java.java

//package g3ds.joop.ch5;

public class MyObjectNonConvention{
	public static void main(String[] args){
		MyModifiedObject m1 = new MyModifiedObject(new StringBuffer("Ten"),10);
		MyModifiedObject m2 = new MyModifiedObject(new StringBuffer("Ten"),10);
		
		System.out.println("使用关系运算符比较对象");
		System.out.println("m1 == m2 : " + ( m1 == m2 ));
		
		System.out.println("使用使用equals()方法比较对象内容");
		System.out.println("m1.equals(m2) : " + m1.equals(m1));
		
		System.out.println("不合格的自定义类散列码：");
		System.out.println("m1.hashCode()="+m1.hashCode());
		System.out.println("m2.hashCode()="+m2.hashCode());
	}
} 

// 自定义一个类
class MyModifiedObject {
	//将变量设为私有
  	private int value;
  	private StringBuffer name;
	
	//利用构造方法参数对变量赋值
	MyModifiedObject(StringBuffer name, int value){
		this.name=name;
		this.value=value;
	}
	
	MyModifiedObject(){
		this(new StringBuffer("Zero"),0);
	}
	
	//设计setValue和getValue
	public void setValue(int value){
		this.value=value;
	}
	
	public int getValue(){
		return value;
	}
	
	//设计setName和getName
	public void setName(StringBuffer name){
		this.name=name;
	}
	
	public StringBuffer getName(){
		return name;
	}

	//设计equals方法
	public boolean equals(Object obj){
		if  (obj instanceof MyModifiedObject){
			return this.value==((MyModifiedObject)obj).value &&
				   this.name==((MyModifiedObject)obj).name;
		}
		return false;
	}

	//同步设计hashCode方法，但这种算法不合适！
	public int hashCode(){
		int hashCode=(new Integer(value).hashCode())^name.hashCode();
		return hashCode;
	}
}