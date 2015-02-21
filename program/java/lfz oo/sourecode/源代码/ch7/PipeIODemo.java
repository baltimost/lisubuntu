//: PipeIODemo.java

//package g3ds.joop.ch7;

import java.io.*;

public class PipeIODemo{
	public static void main(String[] args) throws IOException{
		//创建一个管道输出流对象
		PipedWriter out=new PipedWriter();
		
		//创建一个管道输入流对象
		PipedReader in=new PipedReader();
		//把管道输入流对象和管道输出流对象联接起来
		in.connect(out);
		
		//以上2个语句等效于
		//PipedReader in=new PipedReader(out);
		
		TextGenerator data=new TextGenerator(out);
		data.start();
		
		int ch;
		while((ch=in.read())!=-1)
			System.out.print((char)ch);
		System.out.println();
	}
}


//定义一个线程类
class TextGenerator extends Thread{
	private Writer out;
	
	TextGenerator(Writer out){
		this.out=out;
	}
	
	public void run(){
		try{
			try{
				for(char c='A'; c<='Z'; c++)
					out.write(c);
			}finally{
				out.close();
			}
		}catch(IOException e){
			getThreadGroup().uncaughtException(this, e);
		}
	}
}