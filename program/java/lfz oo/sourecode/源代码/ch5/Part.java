//: Part.java

//package g3ds.joop.ch5;

import java.util.Vector;

public class Part{
	//设计一个用于存储使用该零件车型的集合
	private Vector cars = new Vector();
	
	private PricePolicy pricePolicy;

	public Car[] getCars() { 
		//把集合中的元素转换成Car类型并以数组的方式返回
		return (Car[]) cars.toArray(new Car[0]);
	}

	public void addCar(Car car) {
		//如果使用了某类零件，则把车型加入集合中
		cars.add(car);
	}
	
	//设置定价策略
	public void setPricePolicy(PricePolicy policy){
		pricePolicy=policy;
	}
	
	//通过定价策略为当前零件定价
	public void setPrice(double price){
		pricePolicy.setPrice(price);
	}
	
	//同样经由定价策略获取当前零件的价格
	public double getPrice(){
		return pricePolicy.getPrice();
	}
}