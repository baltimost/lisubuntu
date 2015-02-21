//: StandardIODemo.java

//package g3ds.joop.ch7;

import java.io.*;

public class StandardIODemo{
	public static void main(String[] args) throws IOException{
		//把标准输入的字节流转换成字节流的典型组合
		BufferedReader stdin = new BufferedReader(
        	new InputStreamReader(System.in));
        
        System.out.print("请输入一行文字:");
		System.out.println("您输入的文字是:" + stdin.readLine());
	}
}