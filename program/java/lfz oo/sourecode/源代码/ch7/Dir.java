//: Dir.java

//package g3ds.joop.ch7;

import java.io.*;

public class  Dir{
	//分别用来记录子目录的个数和文件的个数
	static int intDirCount = 0;
	static int intFileCount = 0;
	
	//用来记录所有文件的总长度
	static long totalSize = 0;

	//利用递归方法列出File（及其子目录中）的对象
	public static void recurs(File fl)throws FileNotFoundException{
		String[] fileList=fl.list();
		String filePath=fl.getAbsolutePath();
		
		for(int i=0;i<fileList.length;i++){
			File file=new File(filePath + File.separator + fileList[i]);
			
			//判断是否是普通文件
			if ( file.isFile() ){
				System.out.println(file.getName() + "\t");
				intFileCount ++;
				totalSize += file.length();
			}
			//判断是否是目录
			else {
				System.out.println(file.getName() + " \t<DIR> " );
				intDirCount ++;
				recurs(file);
			}
		}
	}
	
	//测试
	public static void main(String[] args) throws FileNotFoundException{
		File flCurrent = new File(".");
		System.out.println("Files in "+flCurrent.getAbsolutePath());
		
		recurs(flCurrent);
		
		System.out.println(intFileCount + " file(s) \t" + totalSize + " bytes");
		System.out.println(intDirCount + " dir(s) ");
	}
}