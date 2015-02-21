//: FileInfo.java

//package g3ds.joop.ch7;

import java.io.*;

public class FileInfo{
	File fileToCheck;

	public static void main(String[] args) throws IOException{
		if (args.length>0){
			for (int i=0;i<args.length;i++){ 
				File fileToCheck = new File(args[i]);
				info(fileToCheck);
			}
		} 
		else{
			File fileToCheck = new File("FileInfo.java"); 
			info(fileToCheck);
		}
	}

	public static void info(File f) throws IOException{
		System.out.println("文件名: \t"+f.getName());
		System.out.println("绝对路径: \t"+f.getAbsolutePath());
		
		if (f.exists()){
			System.out.println("File exists."); 
			System.out.print((f.canRead() ?"and is Readable ":""));
			System.out.print((f.canWrite()?"and is Writeable":""));
			System.out.println("."); 
			System.out.println("File is " + f.length() + " bytes."); 
		}
		else {
			System.out.println("File does not exist.");
		}
	}
}