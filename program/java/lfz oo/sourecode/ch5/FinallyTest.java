//: FinallyTest.java

//package g3ds.joop.ch5;

import java.io.*;

public class FinallyTest{
	public static void main(String[] args) throws IOException{
		FinallyTest obj=new FinallyTest();
		
		//测试：查找本程序源码中的一行信息
		boolean isFound=obj.searchFor("FinallyTest.java", 
			"import java.io.*;");
		
		if(isFound)
			System.out.println("已找到！");
		else
			System.out.println("未找到！");
	}
	
	public boolean searchFor(String file, String word) 
		throws IOException{
		FileReader input=null;
		String str=null;
		
		try{
			input=new FileReader(file);
			BufferedReader in=new BufferedReader(input);
			
			//得到结果时返回true
			while((str=in.readLine())!=null)
				if(str.equals(word))
					return true;
			
			//否则返回false		
			return false;
		}
		//也可以对感兴趣的异常进行处理
		/*catch(FileNotFoundException e){
			//给出异常提示信息
			System.out.println("找不到指定的文件！");
			
			//同时给出处理：返回false
			return false;
		}*/
		//无论有无异常发生，finally子句都将在控制转移之前被执行
		finally{
			//如果文件以打开，离开前必须关闭文件
			if(input!=null)
				input.close();
				
			System.out.println("控制转移之前finally子句已被执行！");
		}
	}
}