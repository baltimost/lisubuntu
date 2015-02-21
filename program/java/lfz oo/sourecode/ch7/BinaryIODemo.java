//: BinaryIODemo.java

//package g3ds.joop.ch7;

import java.io.*;

public class BinaryIODemo{
	public static void main(String[] args) throws IOException{
		try {
			//把一些数据写到文件Data.txt
			DataOutputStream out =
				new DataOutputStream(
        		new BufferedOutputStream(
        		new FileOutputStream("Data.txt")));
        	
        	/*按不同的数据格式写出*/
        	out.writeBoolean(true);	
			out.writeDouble(3.1415926);
			//DataOutputStream支持把字符串一次格式化写出
			out.writeChars("That was PI\n");
			out.writeBytes("That was PI\n");
			
			//关闭输出流
			out.close();
			
			//准备读入已存储的文件
			DataInputStream in =
				new DataInputStream(
				new BufferedInputStream(
				new FileInputStream("Data.txt")));
			
			BufferedReader buffer = new BufferedReader(
        		new InputStreamReader(in));
          
			//DataInputStream支持基本类型的格式化输入
			System.out.println(in.readBoolean());
			System.out.println(in.readDouble());
			
			//但对于字符串只能借助BufferedReader的readLine完成
			System.out.println(buffer.readLine());
			System.out.println(buffer.readLine());
		} catch(EOFException e) {}
	}
}