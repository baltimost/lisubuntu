//: Car.java

//package g3ds.joop.ch5;

import java.util.Vector;

public class Car extends RoadVehicle implements Refuellable{
	//设计一个用于存储汽车零部件的集合
	private Vector parts = new Vector();

	public Part[] getParts() { 
		//把集合中的元素转换成Part类型并以数组的方式返回
		return (Part[]) parts.toArray(new Part[0]);
	}

	public void addPart(Part part) {
		//把该零部件加入汽车零部件集合中
		parts.add(part);
    
		//同时把该车实例加入当前零部件的车型集合中
		part.addCar(this);  
	}
	
	//统计汽车的所有零部件的成本
	public double totalCost(Part[] parts){
		double total=0.0;
		
		for(int i=0; i<parts.length; i++)
			total+=parts[i].getPrice();
			
		return total;
	}


	//以下内容关于实现接口等内容：
	public boolean license(){
		boolean isOk=false;
		
		//if...
		
		return isOk;
	}
	
	public void refuel(){
		System.out.println("飞机加油.");
	}
	
	public static void main(String[] args){
		 
	}
}