//: ProcessDemo.java

//package g3ds.joop.ch5;

class ProcessDemo{
	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
    	Process p = null;

    	try {
 			//创建一个进程
      		p = r.exec("notepad");
      		
      		//一直等待到进程结束
      		//p.waitFor();
      		
      		//延迟其后的操作
      		new Thread().sleep(2000);
      		//或者强制中断进程，此时exitValue方法会返回非0
      		p.destroy();
    	} catch (Exception e) {}
    
    	System.out.println("Notepad进程返回值：" + p.exitValue());
	}
}