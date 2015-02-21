//: RandomIODemo.java

//package g3ds.joop.ch7;

import java.io.*;

public class RandomIODemo{
	public static void main(String[] args) throws IOException{
		//创建一个随机文件，开放读写权限
		RandomAccessFile rf =
			new RandomAccessFile("rtest.dat", "rw");
		
		//往其中写8个double型数值
		for(int i = 0; i < 8; i++)
			rf.writeDouble(i*3.14);
		//并关闭文件
		rf.close();
		
		//使用时打开文件，并开放读写权限
		rf = new RandomAccessFile("rtest.dat", "rw");
      	
      	//定位到文件第40个字节之后，1个double数值占8个字节
		rf.seek(5*8);
		//并修改其内容
		rf.writeDouble(33.333);
		//关闭文件
		rf.close();
		
		//以只读形式打开文件
		rf = new RandomAccessFile("rtest.dat", "r");
		//以相同的格式输出文件内容
		for(int i = 0; i < 8; i++)
			System.out.print(rf.readDouble() + "\t");
		//关闭文件
		rf.close();
	}
}