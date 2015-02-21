//: OverrideTest.java

//package g3ds.joop.ch4;

public class OverrideTest{
	public static void main(String[] args){
		//测试：当前类将调用自己类中定义的同名方法
		//new Oval().draw();
		//new Rectangle().draw();
		
		//测试：利用声明为超类的数组对象实现对扩展类对象的管理
		Shape[] shapes=new Shape[5];
		for(int i=0; i<shapes.length; i++){
			//创建数组元素
			shapes[i]=createShape((int)(Math.random()*5));
			//调用相应的绘制方法
			shapes[i].draw();
		}
		
	}
	
	//用于测试的创建几何元素方法
	static Shape createShape(int seed){
		Shape shape=null;
		switch(seed){
			case 0:
				System.out.print("创建椭圆...");
				shape=new Oval();
				break;
			case 1:
				System.out.print("创建四边形...");
				shape=new Quadrangle();
				break;
			case 2:
				System.out.print("创建三角形...");
				shape=new Triangle();
				break;
			case 3:
				System.out.print("创建正方形...");
				shape=new Square();
				break;
			case 4:
				System.out.print("创建长方形...");
				shape=new Rectangle();
				break;
		}
		
		return shape;
	}
}

//定义一个抽象类表示几何形状
abstract class Shape{
	//声明一个绘制几何形状的抽象方法
	public abstract void draw();
}

//定义椭圆作为Shape的子类
class Oval extends Shape{
	//采用多态性机制，重新定义方法的实现
	public void draw(){
		System.out.println("绘制椭圆");
	}
}

//定义四边形作为Shape的子类
class Quadrangle extends Shape{
	//采用多态性机制，重新定义方法的实现
	public void draw(){
		System.out.println("绘制四边形");
	}
}

//定义三角形作为Shape的子类
class Triangle extends Shape{
	//采用多态性机制，重新定义方法的实现
	public void draw(){
		System.out.println("绘制三角形");
	}
}

//定义正方形作为Quadrangle的子类
class Square extends Quadrangle{
	//采用多态性机制，重新定义方法的实现
	public void draw(){
		System.out.println("绘制正方形");
	}
}

//定义长方形作为Quadrangle的子类
class Rectangle extends Quadrangle{
	//采用多态性机制，重新定义方法的实现
	public void draw(){
		System.out.println("绘制长方形");
	}
}