//: Fibonacci.java

//package g3ds.joop.ch3;

public class Fibonacci{
	public static void main(String[] args){
		int number;
		long startTime, endTime;
		
		try{
			number=Integer.parseInt(args[0]);
		}catch(Exception e){
			number=32;
		}
		
		System.out.println("迭代法计算Fibonacci("+ number + ")数列：");
		//记录迭代计算开始的时刻
		startTime=System.currentTimeMillis();
		for(int i=0; i<=number; i++){
			System.out.print(FibonacciByIteration(i)+"  ");
		}
		//记录迭代计算结束的时刻
		endTime=System.currentTimeMillis();
		System.out.println("\n迭代法花费的时间（毫秒）："+(endTime-startTime)+'\n');
		
		System.out.println("递归法计算Fibonacci("+ number + ")数列：");
		//记录递归计算开始的时刻
		startTime=System.currentTimeMillis();
		for(int i=0; i<=number; i++){
			System.out.print(FibonacciByRecursion(i)+"  ");
		}
		//记录递归计算结束的时刻
		endTime=System.currentTimeMillis();
		System.out.println("\n递归法花费的时间（毫秒）："+(endTime-startTime));
	}
	
	//采用迭代法计算Fibonacci数列
	public static long FibonacciByIteration(long n){
		if(n==0L || n==1L) return n;
		else{
			//循环的初始条件
			long n1=0L;
			long n2=1L;
			
			long result=0L;
			//迭代计算
			for(long times=2L; times<=n; times++){
				result=n1+n2;
				n1=n2;
				n2=result;		
			}
			return result;
		}
	}
	
	//采用递归法计算Fibonacci数列
	public static long FibonacciByRecursion(long n){
		//递归调用的两个基本实例
		if(n==0L || n==1L) return n;
		//递归调用
		else return (FibonacciByRecursion(n-2)+FibonacciByRecursion(n-1));
	}
	
	
}