//: EggOrChicken.java

//package g3ds.joop.ch4;

public class EggOrChicken{
	public static void main(String[] args){
		new Chicken();
	}
}

class Egg{
	//
	Chicken aChicken=new Chicken();
	Egg(){
		System.out.println("蛋生鸡");
	}
}

class Chicken{
	//
	static Egg aEgg=new Egg();
	Chicken(){
		System.out.println("鸡生蛋");
	}
}

/*
当两个类中均声明为实例变量时将引发运行时错误：
Exception in thread "main" java.lang.StackOverflowError
	at Egg.<init><EggOrChicken.java:13>
	at Chicken.<init><EggOrChicken.java:21>
	//……重复以上二句
*/