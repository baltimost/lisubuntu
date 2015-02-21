//:AppMain.java
//在一个源文件中可以包括多个main(String[] agrs)
//package g3ds.joop.ch2;

public class AppMain{ //an application 
	//定义内嵌类InnerMain，为了对比用，声明为static
	static class InnerMain{
		public static void main(String[] agrs){
			System.out.println("Class InnerMain: Hello World!");
		}
	}

	public static void main(String[] agrs){ 
		System.out.println("Class AppMain: Hello World!"); 

		//典型的利用创建实例再调用方法
		//NonAppMain aNonAppMain=new NonAppMain();
		//aNonAppMain.main();

		//利用static性质的调用方法，可以不必创建实例
		NonAppMain.main();
		InnerMain.main(agrs);
		OuterMain.main(agrs);

	} 
}

//定义外部类OuterMain，其中定义了一模一样的main方法
class OuterMain{
	public static void main(String[] agrs){ 
		System.out.println("Class OuterMain: Hello World!"); 
	}
}