//: FinalizeTest.java

//package g3ds.joop.ch4;

public class FinalizeTest {
	public static void main(String[] args)  {
		for(int i=0; i<10;i++){
			//创建一系列Seed对象,
			//因为这些对象并不被引用，一经创建就成为事实上的"垃圾"
			new Seed();	
		}
		//输出创建对象总数信息
		System.out.println(Seed.gcount+" instances are created.");
		
		//获得当前的Runtime对象
		Runtime rt=Runtime.getRuntime();
		
		//输出创建对象后当前机器的可用内存及内存总数情况
		System.out.println("Memory before Garbage Collection:"+
			rt.freeMemory()+"/"+rt.totalMemory());
		
		//请求垃圾回收
		rt.gc();
		//或者
		//System.gc();//相当于Runtime.getRuntime().gc();
		
		/***由于垃圾收集程序是一个优先级最低的线程，
			启动时机不确定，因此以下的输出结果不一定一样***/
		//输出调用垃圾收集程序以后被清除的对象总数
		System.out.println(Seed.fcount+" instances are killed.");
		//输出调用垃圾收集程序以后当前机器的可用内存及内存总数情况
		System.out.println("Memory after Garbage Collection:"+
			rt.freeMemory()+"/"+rt.totalMemory());
		
		System.exit(0);
	}
} 

class Seed{
	//gcount用来记录创建的实例总数
	static int gcount=0;
	//fcount用来记录已被清除的实例总数
	static int fcount=0;
	
	public Seed(){
		//创建实例时gcount自增1
		gcount++;
		
		//显示所创建实例的信息
		System.out.println("Instance:"+this.toString()+" instances are created.");
	}
	
	protected void finalize() throws Throwable{
		//调用父类的finalize方法
		super.finalize();
		
		//清除实例时fcount自增1
		fcount++;
		
		//显示被清除实例的信息
		System.out.println("Instance:"+this.toString()+"  instances are killed.");
	}
}