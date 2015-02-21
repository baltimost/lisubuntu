//: EvaluationOrder.java

//package g3ds.joop.ch3;

public class EvaluationOrder{
	public static void main(String[] args){
		int a=20;

		/* "5+++a"需在第一个“＋”号后插入空格（ 分隔符优先考虑），
		   否则根据操作数先赋值以及从左到右的组合原则，会把“++”赋予数值5
		   （不是变量，无法自增），引发错误如下：
			unexcepted type
			required:variable
			found:value
			1 error
		*/
		System.out.println("a=" + a);
		System.out.println("(5+ ++a)="+(5+ ++a));
		System.out.println("其后a=" + a);

		/*
		   而“5+--a”可以不加空格，因为不存在“+-”相连的运算符号，因此“+--”理解为
		   加运算右边操作数自减赋值，即先进行一元运算“--”，再进行二元运算“+”。
		   分析“++a+++a”将有助于理解变量和操作数的含义：断句时，根据自左向右组合原则，
		   连续三个“+++”将被理解为加运算的左边操作数进行自增运算，在进行加运算之前，先
		   对操作数赋值，左边表达式赋值时试图对同一个变量执行二次自增运算，由于a++得到的
		   是数值，再执行自增运算将引发编译时错误。
		*/
		System.out.println("(5+--a)="+(5+--a));
		System.out.println("其后a=" + a);
		System.out.println("(++a+ ++a)="+(++a+ ++a));
		System.out.println("其后a=" + a);

		// 如果把表达式改为a+++5或者a+++a则是合法的，同样的道理，
		// 根据从左到右的组合原则，将“++”组合到左边的变量a。
		System.out.println("(a+++5)="+(a+++5));
		System.out.println("其后a=" + a);
		System.out.println("(a+++a)="+(a+++a));
		System.out.println("其后a=" + a);

		// 左边操作数先赋值，并改变了变量a的值，将影响到右边的操作数
		System.out.println("((a=20)+a)="+((a=20)+a)); 
		System.out.println("其后a=" + a);
		// 而右边操作数赋值改变了变量a的值，并不会影响左边的操作数
		System.out.println("(a+ (a=15))="+(a+ (a=15))); 
		System.out.println("其后a=" + a + '\n');
		
		// 如果在为操作数赋值的过程中发生异常，则当前位置右边的赋值操作中断
		int b=1;
		try{
			int i=forgetIt()/(b=2);
		}catch(Exception e){
			System.err.println(e);
			System.out.println("右边赋值操作中断：b="+ b);
		}
		
		// Java语言遵循先赋值后运算原则
		try{
			int i=a/(b=0)*forgetIt();
		}catch(Exception e){
			System.out.println("\n赋值以后检查除运算是否合法，不合法时引发异常：");
			System.err.println(e);
		}
		
		// 如果赋值过程发生异常，则运算也将中断
		try{
			int i=a/((b=0)*forgetIt());
		}catch(Exception e){
			System.out.println("\n赋值过程引发异常，不进一步检查除运算是否合法：");
			System.err.println(e);
		}
		
		// 由于运算的优先级与顺序性，导致数学意义上的恒等式其机器运算结果不同
		double d=8e+307;
		System.out.println("\n(4.0*d*0.5)=" + (4.0*d*0.5));
		System.out.println("(2.0*d)=" + (2.0*d));
		
		// 作为方法的传递参数，赋值过程同样遵循从左到右原则
		String str="left";
		System.out.println("\n赋实参时同样遵循从左到右原则：");
		passArgument(str, str="right");
	}
	
	// 设计引发异常的方法
	static int forgetIt() throws Exception{
		throw new Exception("赋值过程引发异常！");
	}
	
	// 设计带参数的方法
	static void passArgument(String str1, String str2){
		System.out.println(str1+"  "+str2);
	}
}
