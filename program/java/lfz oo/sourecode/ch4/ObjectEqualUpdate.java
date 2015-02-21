//: ObjectEqualUpdate.java

//package g3ds.joop.ch4;

public class ObjectEqualUpdate{
	public static void main(String[] args){
		Integer n1 = new Integer(100);
		Integer n2 = new Integer(100);
		MyIntUpdate m1 = new MyIntUpdate(100);
		MyIntUpdate m2 = new MyIntUpdate(100);
		
		System.out.println("使用关系运算符比较对象");
		System.out.println("n1 == n2 : " + ( n1 == n2 ));
		System.out.println("m1 == m2 : " + ( m1 == m2 ));
		
		System.out.println("使用使用equals()方法比较对象内容");
		System.out.println("n1.equals(n2) : " + n1.equals(n2));
		System.out.println("m1.equals(m2) : " + m1.equals(m1));
	}
} 

// 自定义一个类
class MyIntUpdate {
	//将变量设为私有
  	private int value;
	
	//利用构造方法参数对变量赋值
	MyIntUpdate(int value){
		this.value=value;
	}
	
	MyIntUpdate(){
		this(0);
	}
	
	//利用setValue赋值
	public void setValue(int value){
		this.value=value;
	}
	
	//利用getValue获取值
	public int getValue(){
		return value;
	}

	//直接仿照Integer类中equals方法的设计
	public boolean equals(Object obj){
		if  (obj instanceof MyIntUpdate){
			return this.value==((MyIntUpdate)obj).value;
		}
		return false;
	}

	/*——equals方法的另一个设计版本——
	//（参见机械工业出版社，Steven L. Halter等，Java技术精髓，
	//  书名原文：Enterprise Java Performance）
	//以上方法传递参数的类型为Object，具有最大的普适性，
	//适用于一般情况下的对象比较，避免引发异常，但对于类型相同的对象比较，
	//instanceof检查就是多余的，增加了运算开销。因此这一方法的优化版本如下：
	public boolean equals(Object obj){
		//直接做类型转换，当类型不匹配时将引发转型异常，避免instanceof和转型相邻使用
		try{
			return this.value==((MyIntUpdate)obj).value;
		}
		catch(ClassCastException cce){
			//如果类型不匹配则返回false
			return false;
		}
	}
		
	//而且，在大多数情况下为同类型比较，因此增加以下方法以减少开销
	public boolean equals(MyIntUpdate obj){
		return this.value==obj.value;
	}
	*/
}