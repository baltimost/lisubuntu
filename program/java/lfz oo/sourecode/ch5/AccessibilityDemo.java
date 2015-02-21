//: AccessibilityDemo.java

package g3ds.joop.ch5;

import g3ds.joop.ch5.points.*;
import g3ds.joop.ch5.threePoint.*;

//对于不同包中不存在继承关系的类，只能聚合其它包中的public类型
//并且只能调用其中声明为public访问权限的方法
class AccessibilityDemo{
	public static void main(String[] args){
		//可以用完全限定名声明一个对象
		g3ds.joop.ch5.points.Point p1 = new g3ds.joop.ch5.points.Point(1,1);
		p1.show();
		
		//不同包中public类型可以访问
		Point p2 = new Point(2,2);
		p2.show();
		
		Point3d p3=new Point3d();
		p3.show();
		
		Point3dSamePkg p4=new Point3dSamePkg();
		p4.show();
		
		//不同包中非public类型无法访问
		//PointList p5=new PointList();
	}
}