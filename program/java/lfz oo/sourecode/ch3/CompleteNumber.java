//: CompleteNumber.java
/*
  要判断一个自然数是否为完数，首先必须找到其所有因数。
  而一个数的所有因数可以利用计算机速度快的特点，从2开始到这个数的最大因数
  为止（偶数不大于其值的二分之一，奇数不大于其值的三分之一），进行取模判断，
  凡是可以被整除的数均为该数的因数。
*/

//package g3ds.joop.ch3;

public class CompleteNumber{
	public static void main(String[] args){
		int i;
		try{
			i=Integer.parseInt(args[0]);
		}catch(Exception e){
			i=10000;
		}
		
		seekNumber(i);
	}
	
	public static void seekNumber(int i){
		int number=2;
		int factor=1;
		String str="1";
		int maxDivisor, divisor;
		
		do{
			if(number%2==0)
				maxDivisor=number/2;
			else
				maxDivisor=number/3;
			
			divisor=2;
			while(divisor<=maxDivisor){
				if(number%divisor==0){
					factor +=divisor;
					str +=(" + "+ divisor);
				}
				
				divisor++;
			}
			
			if(factor==number)
				System.out.println(number + "=" + str);
				
			number++;
			
			factor=1;
			str="1";			
		}while(number<=i);
	}
}