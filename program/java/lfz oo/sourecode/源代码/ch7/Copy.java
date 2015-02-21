//Copy.java

//package g3ds.joop.ch7;

import java.io.*;

public class  Copy{
	public static void main(String[] args){
		if ( args.length < 2 ){
			System.out.println("用法: Copy [源文件名] [目标文件名] .");
		}
		else{
			File fSource = new File(args[0]);
			boolean isOK = true ;
			
			// 判断源文件是否存在
			if (!fSource.exists()){
				System.out.println("Source File "+args[0]+" is not a exist!");
				isOK = false ;
			}
			
			// 判断源文件是否是文件,而不是目录
			if (isOK && !fSource.isFile()){
				System.out.println("Source File "+args[0]+" is not a file!");
			}
			
            // 判断源文件是否可读
			if (isOK && !fSource.canRead()){
				System.out.println("Can not read "+"Source File "+args[0]+"!");
			}
			
			File fDestination = new File(args[1]);
			try{
				// 判断目标文件是否存在,如果存在是否覆盖
				if (isOK && fDestination.exists()){
					System.out.println("Destination File "+args[1]+" is already  exist!");
					System.out.print("Overwrite ? [y/n] ");
					
					int ch = System.in.read();
					if ( ch == 'n' || ch == 'N'){
						isOK = false ;
					}
				}
				
				// 如果一切正常,那么对文件进行复制
				if ( isOK ){
					FileInputStream fisSource = new FileInputStream(args[0]);
					FileOutputStream fosDestination = new FileOutputStream (args[1]);
					
					System.out.println("Copy file from "+args[0]+" to "+args[1]+"...");
					
					while (fisSource.available() > 0){
						int temp = fisSource.read ();
						fosDestination.write (temp);
					}
					
					fisSource.close();
					fosDestination.close();
					
					System.out.println("File Copyed Successfully!");
				}
			}catch (IOException e){}
		}	
	}
}