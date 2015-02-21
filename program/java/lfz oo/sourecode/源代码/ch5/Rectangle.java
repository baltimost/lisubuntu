//: Rectangle.java

//package g3ds.joop.ch5;

public class Rectangle{
	//矩形的长和宽
	private double width;
	private double height;
	
	public Rectangle(double w, double h){
		width=w;
		height=h;
	}
	
	//计算矩形的面积	
	public double area(){
		return width*height;
	}
	
	//设置矩形边长值
	public void setWidth(double w){
		width=w;
	}
	
	public void setHeight(double h){
		height=h;
	}
		
	public double getWidth(){
		return width;
	}
	
	public double getHeight(){
		return height;
	}
}