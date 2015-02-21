//: Polygon.java

//package g3ds.joop.ch5;

public class Polygon {
	//定义一个组成多边形节点的数组对象
	private Point[] points;
	
	//取得节点信息
	public Point[] getPoints() { 
		return points;
	}
	
	public Polygon(Point[] points) throws Exception {
		if (points.length < 3) 
			throw new Exception("节点数应不少于3个!");
		this.points = points; 
	}
}