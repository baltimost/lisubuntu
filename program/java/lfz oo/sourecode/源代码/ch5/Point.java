//: Point.java

//package g3ds.joop.ch5;

//定义一个记录二维点坐标的类型
public class Point {
	//坐标点变量
	double x, y;  

	public Point(double x, double y) {
		this.x = x; 
		this.y = y; 
	}

	public double getX() { 
		return x; 
	}

	public double getY() { 
		return y; 
	}
}