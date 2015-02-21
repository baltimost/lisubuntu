//: PassByRefValue.java

//package g3ds.joop.ch4;

public class PassByRefValue{
	public static void main(String[] agrs){
		//姑且记作main->str1
		StringBuffer str1=new StringBuffer("abc");
		//姑且记作main->str2
		StringBuffer str2=new StringBuffer("123");
		
		PassByRefValue byRef=new PassByRefValue();
		
		//输出main->str1、main->str2
		System.out.println("main->str1 before swap method: "+str1);
		System.out.println("main->str2 before swap method: "+str2);
		
		//swap方法调用实参，即
		//main->str1赋予swap->str1、此时main->str1、swap->str1指向"abc"；
		//main->str2赋予swap->str2、此时main->str2、swap->str2指向"123"；
		//转swap方法体中...
		byRef.swap(str1, str2);
		
		//但没有办法影响实参的引用，实参仍指向原来的对象
		//输出main->str1、main->str2
		System.out.println("main->str1 after swap method: "+str1);
		System.out.println("main->str2 after swap method: "+str2);
	}
	
	//交换了形参的引用，但作用于只在方法体中，无法返回
	//形参姑且记作swap->str1、swap->str2
	void swap(StringBuffer str1, StringBuffer str2){
		//把swap->str1的引用值赋予swap->temp
		//此时main->str1、swap->str1、swap->temp指向同一对象"abc"
		StringBuffer temp=str1;
		
		//把swap->str2的引用值赋予swap->str1，但不影响main->str1
		//此时main->str2、swap->str1、swap->str2指向同一对象"123"
		//而main->str1、swap->temp指向另一对象"abc"
		str1=str2;
		
		//把swap->temp的引用值赋予swap->str2，但不影响main->str2
		//此时main->str1、swap->temp、swap->str2指向同一对象"abc"
		//而指向main->str2、swap->str1另一对象"123"
		str2=temp;
		
		//输出swap->str1、swap->str2
		System.out.println("swap->str1 in swap method: "+str1);
		System.out.println("swap->str2 in swap method: "+str2);
	}
}