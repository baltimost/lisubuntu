//: Control.java

//package g3ds.joop.ch3;

import java.io.*; 

/** 
 * A demo for statements
 * @version 1.00, 10/01/03
 * @author	Global 3D Studio
 * @see  Kid
 * @since	Java OOP Ver.1
 */ 
public class Control{
	
	public static void main(String[] args) throws IOException{
		//声明变量
		int i, j;
		String input;
		boolean isPrint;
		
		//由键盘输入值判断是否打印		
		System.out.print("是否打印乘法口诀表？\n打印[y]，不打印[n]：[y]");
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		input=in.readLine();
		
		if(input.equals("n"))
			isPrint=false;
		else
			isPrint=true;
			
		//打印由方法调用而返回的字符串
		System.out.println(showMessage(isPrint));
			
		outer://外层循环标识
		for(i=0;i<10;i++){
			//利用continue语句结束本次循环
			if(i==0) continue;
			
			inner://内层循环标识
			for(j=0;j<10;j++){
				//如果不打印，利用带标识break语句退出外层for语句
				if(!isPrint) break outer;
				
				//利用continue语句结束本次循环,其中的标识"inner"可以省略
				if(j==0) continue inner;
				
				//打印乘法口诀
				if(i==1) System.out.print(i*j +"\t" );
				else {
					//利用break语句退出内层for语句
					if(j>i) break;
					System.out.print(i*j +"\t" );
				}
			}
			System.out.println();
		}
	}
	
	//return语句的使用示例
	public static String showMessage(boolean isPrint) {
		if(isPrint)
			return "******************\n好好学习，天天向上\n******************";
		else
			return "******************\n温故知新，戒骄戒躁\n******************";
	}
}