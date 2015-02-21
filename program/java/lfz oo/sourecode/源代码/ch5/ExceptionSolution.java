//: ExceptionSolution.java

//package g3ds.joop.ch5;

import java.io.*;

public class ExceptionSolution{
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
    		try {
    			//以下为受保护代码，在交互过程可能引发异常
    			System.out.print("请输入整型被除数:");
    			dividend=Integer.parseInt(in.readLine());
    	
    			System.out.print("请输入整型除数:");
    			divisor=Integer.parseInt(in.readLine());
			
				result=dividend/divisor;
				System.out.println("结果：("+dividend+"/"+divisor+")="+ result);
			} 
			//对除数为0引发的ArithmeticException异常进行回应
			catch(ArithmeticException e) {
				//处理异常时给出便于理解的、最直截了当的提示
				System.out.println("对不起！您的输入有误：除数为0");
				
				//也可以直接输出和异常有关的信息，但对用户来说这些内容过于抽象
				//e.printStackTrace(System.err);
			} 
			//对类型转换过程引发的NumberFormatException异常进行回应
			catch(NumberFormatException e){
				//处理异常时给出便于理解的、最直截了当的提示
				System.out.println("对不起！您的输入有误：除数或被除数不是整型数");
				
				/*
				//也可以直接输出和异常有关的信息，但对用户来说这些内容过于抽象
				//直接输出错误点向上的异常信息
				System.out.println("利用printStackTrace方法直接输出堆栈信息：");
				e.printStackTrace(System.err);
				
				//或者利用getStackTrace方法返回这些堆栈信息，调试时可以得到更多的信息
				System.out.println("利用getStackTrace方法返回堆栈信息：");
				StackTraceElement ste[] = e.getStackTrace();
				for(int i=0; i<ste.length; i++){
					System.out.println("异常产生在 "+ ste[i].getClassName() +" 类的 "+
						ste[i].getMethodName()+" 方法");
					System.out.println("在 "+ste[i].getFileName()+" 文件中的"+
						"第 "+ste[i].getLineNumber()+" 行");
				}
				System.out.println("错误原因： "+e.getMessage());
				*/
			} 
			//以防万一，对可能引发的意想不到的异常进行回应
			catch(Exception e){
				//处理异常时给出便于理解的、最直截了当的提示
				System.out.println("对不起！操作出现故障：请重新试试");
				
				//也可以直接输出和异常有关的信息，但对用户来说这些内容过于抽象
				//e.printStackTrace(System.err);
			}

			System.out.print("继续计算[是（Y）/否（N）]: ");
			
			//给出强制退出循环的条件
			if(!new String(in.readLine()).trim().equalsIgnoreCase("Y"))
				break;
		}
	}
} 