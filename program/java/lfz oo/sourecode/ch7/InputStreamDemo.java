//: InputStreamDemo.java

//package g3ds.joop.ch7;

import java.io.*;

public class InputStreamDemo{
	public static void main(String[] args) throws IOException{
		InputStream in;
		
		if(args.length==0){
			System.out.println("用法：\t\"java InputStreamDemo S\" 演示标准输入流"+ 
				"\n\t\"java InputStreamDemo F\" 演示文件输入流");
			return;
		}
		
		if(args[0].equalsIgnoreCase("S"))
			//读取标准输入流
			in=System.in;
		else if(args[0].equalsIgnoreCase("F"))
			//读取文件输入流
			in=new FileInputStream("InputStreamDemo.java");
		else
			return;
			
		int total=0;
		int b=0;
		while((b=in.read())!=-1){
			total++;
			System.out.print((char)b);
			
			//作为读操作结束标志，有些平台用Ctrl+C也可以执行其后语句
			if((char)b=='@')
				break;
		}
		
		System.out.println();
		System.out.println(total+"bytes");
	}
}