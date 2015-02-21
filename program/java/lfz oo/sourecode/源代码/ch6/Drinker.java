//: Drinker.java

//package g3ds.joop.ch6;

public class Drinker{
	private String name;
	
	//饮者留其名
	public Drinker(String name){
		this.name = name;
	}
	
	//选择饮品
	public void drink(Beverage beverage){
		System.out.println(name + "自己挑的饮料是：" + beverage.getName());
		
		//开始饮之
		beverage.start();
	}
	
	//测试不相关线程
	public static void main(String[] args){
		new Drinker("唐伯虎").drink(new Beverage("咖啡"));
		
		new Drinker("张三丰").drink(new Beverage("啤酒"));
	}
}


class Beverage extends Thread{
	private String name;
	
	//饮品种类名
	Beverage(String name){
		super(name);
		
		this.name=name;	
	}
	
	//重写Thread类的run方法
	public void run(){
		while(true){
			//开饮
			drink();
		
			//不作牛饮状，尽量让出CPU控制权		
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){}
			
			Thread.yield();
		}
	}
	
	//具体饮品的饮法，若有必要可扩展类覆盖之
	void drink(){
		System.out.println("我喜欢喝" + name + "...");
	}
}