//: FileIODemo.java

//package g3ds.joop.ch7;

import java.io.*;

public class FileIODemo{
	private String strTemp;
	private String  strFinal=new String();
	
	//测试
	public static void main(String[] args) throws IOException{
		FileIODemo obj = new FileIODemo();
		
		//打开一个文件FileIODemo.java
		obj.open("FileIODemo.java");
		//把它另存为FileIODemo.txt，并加上行号
		obj.saveAs("FileIODemo.txt");
	}
	
	public void open(String fileName){
		try{
			//把文件内容读入缓存
			BufferedReader in = new BufferedReader(
				new FileReader(fileName));
		
			while((strTemp = in.readLine())!= null)
				strFinal += strTemp + "\n";
			
			//关闭文件
			in.close();
		}catch(IOException e){}
	}
	
	public void saveAs(String fileName){
		try {
      		//读入缓存中文件的内容
      		BufferedReader in = new BufferedReader(
				new StringReader(strFinal));
			
			//定义写出的文件名
			PrintWriter out = new PrintWriter(
				new BufferedWriter(new FileWriter(fileName)));
            
            //写过程
			int lineCount = 1;
			while((strTemp = in.readLine()) != null )
				out.println(lineCount++ + ": " + strTemp);
			
			//关闭文件
			in.close();	
			out.close();
		} catch(IOException e) {}
	}
}