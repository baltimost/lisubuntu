//: Kid.java

//package g3ds.joop.ch6;

public class Kid{
	//设计得到并吃蛋糕的方法
	public void eat(Cake cake){
		//试图得到一片蛋糕
		Cake piece = cake.getPiece();
		
		if(piece != null){		
			//如果分到一份蛋糕，就可以吃啦...
			piece.start();
		}
	}
	
	//测试相关但无需同步的线程
	public static void main(String[] args){
		//设定人数和蛋糕片数，也可设计成通过参数传递进来
		int number = 5;
		
		Kid[] kids = new Kid[number];
		
		//情景输出
		System.out.println("数一数，有 " + kids.length + " 位小朋友。");
		
		//订了蛋糕
		Cake chocolate = new Cake("巧克力", number);
		
		//测试蛋糕没有归属则无法被吃的情况
		chocolate.start();
		
		try{
			//让以上的线程结束后继续下面的语句
			chocolate.join();
		}catch(InterruptedException e){}
		
		System.out.println();
		for(int i=0; i<kids.length; i++){
			kids[i] = new Kid();
			
			//分蛋糕并品尝之
			kids[i].eat(chocolate);
		}
		
		//设置睡眠时间，以便其它线程有时间启动，用join方法更佳
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){}
		
		//测试计划之外又来人的响应
		System.out.println();
		System.out.println("这时又来了一位小朋友...");
		Kid unluckyKid = new Kid();
		unluckyKid.eat(chocolate);
	}
}


//设计线程类
class Cake extends Thread{
	private int count;
	private boolean isBelonged;
	private Cake[] pieces;
	
	//提供给外部使用的构造方法，相当于每次买的都是大蛋糕
	Cake(String kind, int number){
		System.out.println("今天订的是" + kind + "蛋糕，好吃极啦！");
		
		pieces = new Cake[number];
		
		for(int i=0; i<pieces.length; i++){
			//把蛋糕切片
			pieces[i] = new Cake();
		}
		
		System.out.println("最多可分给 " + number + " 位小朋友。");
		
		//用来记录蛋糕是否分完
		count = number;
	}
	
	//专门用来生成蛋糕片，当然还是蛋糕，只不过小些而已！
	private Cake(){}
	
	//重写的run方法
	public void run(){
		try{
			//还没人吃的状况
			if(!isBelonged){
				System.out.println("人还没来哩，怎么吃呀！");
				
				//提示后直接返回
				return;
			}
			
			//蛋糕已经分到小朋友手中后可进行的状况，实际是线程的主要内容	
			System.out.println(this.getName() + "正被品尝...");
			
			Thread.sleep(500);		
		}catch(InterruptedException e){}
	}
	
	//设计用来分蛋糕的方法
	public Cake getPiece(){
		//蛋糕分完的状况
		if(count<=0){
			System.out.println("对不起，你来晚了，蛋糕已经分完！");
			
			return null;
		}
		
		//还有蛋糕的状况
		int i = count-1;	
		
		pieces[i].isBelonged = true;
		pieces[i].setName("第" + count + "片蛋糕");
		
		count--;
		
		return pieces[i];
	}
}