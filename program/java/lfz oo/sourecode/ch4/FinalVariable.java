//: FinalVariable.java

//package g3ds.joop.ch4;

public class FinalVariable{
	public static void main(String[] args){
		//对于基本类型
		final double PI=3.1415926;
		/*
		  不能再改变final型变量PI的值，否则报错：
		      cannot assign a value to final variable PI
		*/
		//PI=3.14;
		
		//对于数组类型
		final int[] intArray=new int[5];
		for(int i=0; i<intArray.length; i++)
			System.out.print(intArray[i] + " ");
		System.out.println();
		
		/*
		  不能再改变final型变量intArray的引用，否则报错：
		      cannot assign a value to final variable intArray
		*/
		//intArray=null;
		
		//但可以改变数组元素的值
		for(int i=0; i<intArray.length; i++){
			intArray[i]=i;
			System.out.print(intArray[i] + " ");
		}
		
		//对于类类型
		final StringBuffer str=new StringBuffer("Hello ");
		
		/*
		  不能再改变final型变量str的引用，否则报错：
		      cannot assign a value to final variable str
		*/
		//str=new StringBuffer("Hello ");
		
		//但可以改变引用对象的属性
		str.append("world.");
		System.out.println("\n" + str);
		
	}
}