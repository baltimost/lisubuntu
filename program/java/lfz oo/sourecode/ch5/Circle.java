//: Circle.java

//package g3ds.joop.ch5;

public class Circle {
	//圆半径
	private double radius;

	//记录圆心坐标，该坐标点是本类的一部分
	private Point center;
	
	//取得圆心坐标点信息
	public Point getCenter() { 
		return center;
	}
	
	public Circle(double radius, Point center) throws Exception {
		if (radius < 0.0) 
    		throw new Exception("半径值应大于0!");
		this.radius = radius; 
		this.center = center; 
	}

	public double getRadius() { 
		return radius;
	}
}