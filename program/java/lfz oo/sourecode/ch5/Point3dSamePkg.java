//: Point3dSamePkg.java

//同一个包中可以直接访问父类除private外的所有成员
package g3ds.joop.ch5.points;

//Point3d类扩展了Point类，用来表达三维点信息
public class Point3dSamePkg extends Point {
	//声明第三维坐标变量
	protected int z;
	
	//父类的show方法为public访问权限，能被覆盖以使它能反映三维点坐标信息
	public void show(){
		//getID方法为protected访问权限，能够被子类覆盖，存在转型时直接调用子类方法
		System.out.print(getID());
		
		//x、y变量也为protected访问权限，能够被子类直接继承使用
		System.out.println(": "+x+", "+y+", "+z);
	}
	
	//增加用户访问点Z坐标值的接口
	public int getZ(){
		return z; 
	}
	
	//设计一个与父类同名的缺省访问权限的next方法，因为在同一个包中，此方法可被覆盖
	void next() {
		System.out.println("显示下一个三维坐标点的信息...");
	}
	
	//protected访问权限作用域包含子类，因此getID方法可被覆盖
	protected int getID(){
		System.out.println("In Point3dSamePkg...");
		return super.getID();
	}
	
	//用于测试的main方法
	public static void main(String[] args){
		Point p2 = new Point(2,2);
		//显然，访问权限为private的方法不能在本类之外被调用
		//p2.setMasterID();
		//由于在同一个包中的优势，以下的语句均可用
		int x1=p2.x;
		int ID=p2.getID();
		p2.next();
				
		//只有具有public访问权限的方法可以在包外的实例中被调用！
		System.out.println("x="+p2.getX());
		p2.show();
		
		//存在转型的情况
		Point p3=new Point3dSamePkg();
		//调用子类的方法
		p3.show();
		
		//父类的next方法为缺省访问权限，作用域在同一个包中，可被覆盖
		p3.next();
		
		//当然也可以强制类型转换调用Point3dSamePkg的next方法
		((Point3dSamePkg)p3).next();
	}
}