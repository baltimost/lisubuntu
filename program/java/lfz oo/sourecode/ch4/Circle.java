//: Circle.java

//package g3ds.joop.ch4;

public class Circle{
	//声明一种画圆方法中与圆有关的参数
	private int x;
	private int y;
	private int r;
	
	//定义了一种画圆方法的一般形式
	public Circle(int x, int y, int r){
		this.x=x;
		this.y=y;
		this.r=r;
		draw();
	}
	
	//当没有指定位置时，在坐标原点处画圆
	public Circle(int r){
		this(0, 0, r);
	}
	
	//即便什么条件没给，画圆时也不应该崩溃，只是给了一个缺省值
	public Circle(){
		this(0, 0, 10);
	}
	
	//将其中的绘制动作抽取出来，定义成一个实例方法
	public void draw(){
		System.out.println("画圆：圆心（"+x+", "+y+"），半径R="+r);
	}
	
	public static void main(String[] args){
		//测试
		new Circle();
		new Circle(50);
		new Circle(10,10,10);
	}
}