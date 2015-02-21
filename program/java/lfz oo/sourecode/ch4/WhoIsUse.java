//: WhoIsUse.java

//package g3ds.joop.ch4;

public class WhoIsUse{
	public static void main(String[] agrs){
		//创建一个值为5的Integer实例，因为没有及时对其进行引用
		//实际上这个对象一创建出来就无法再被使用，随时有可能被清除掉
		new Integer(5);
		
		//创建一个值为5的Integer实例，仍然没有对其进行引用
		//但在该语句中可以调用该对象的方法或属性，以后也无法再被使用
		int i=new Integer(5).intValue();
		System.out.println(i);
		
		//创建一个值为10的Integer实例，并及时对其进行引用
		//此后可以利用此引用类型变量myInt来使用该对象
		Integer myInt=new Integer(10);
		
		i=myInt.intValue();
		System.out.println(i);
		
		//创建一个值为100的Integer实例，并及时对其进行引用
		Integer anotherInt=new Integer(100);
		System.out.println(anotherInt.intValue());
		
		//引用类型变量myInt指向值为100的Integer实例，这时它将和anotherInt
		//共享同一个对象，而原来myInt引用的值为10的对象已不再被使用，可以被清除
		myInt=anotherInt;
		System.out.println(myInt.intValue());
		
		//如果我们把myInt和anotherInt的引用断开，则值为100的对象也可以被清除
		myInt=null;
		anotherInt=null;
	}
}