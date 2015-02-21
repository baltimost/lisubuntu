//:ProcessOrNot.java

//package g3ds.joop.ch5;

public class ProcessOrNot{
	public static void main(String[] args){
		int result=0;
		
		//对异常不处理
		result=5/0;

		/*
		//对异常进行处理
		try {
			result=5/0;
		} catch(ArithmeticException e) {
			e.printStackTrace(System.err);
		}
		*/

		//检测程序段之后的操作
		System.out.println("result="+ result);
	}
}