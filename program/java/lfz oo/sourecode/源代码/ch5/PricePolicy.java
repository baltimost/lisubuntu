//: PricePolicy.java

//package g3ds.joop.ch5;

//设计一个定价策略类型
public class PricePolicy{
	//本类只关心产品的基本价格情况
	protected double basePrice;
	
	public void setPrice(double price){
		basePrice=price;
	}
	
	public double getPrice(){
		return basePrice;
	}
}