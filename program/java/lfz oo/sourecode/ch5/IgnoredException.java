//: IgnoredException.java

//package g3ds.joop.ch5;

import java.io.*;

public class IgnoredException{
	public static void main(String[] args) throws IOException{
		//定义3个整型变量用来记录输入值及计算结果
		int dividend=0;
		int divisor=0;
		int result=0;
		
		//创建一个记录字符流的对象，用来读入一行标准输入字符
		BufferedReader in =new BufferedReader(
        	new InputStreamReader(System.in));
        	    
    	//设置一个无限循环，用于多次计算，直到给出结束字符跳出
    	for(;;){	
    		System.out.print("请输入整型被除数:");
    		dividend=Integer.parseInt(in.readLine());
    	
    		System.out.print("请输入整型除数:");
    		divisor=Integer.parseInt(in.readLine());
			
			result=dividend/divisor;
			System.out.println("结果：("+dividend+"/"+divisor+")="+ result);
			
			System.out.print("继续计算[是（Y）/否（N）]: ");
			
			//给出强制退出循环的条件
			if(!new String(in.readLine()).trim().equalsIgnoreCase("Y"))
				break;
		}
	}
} 