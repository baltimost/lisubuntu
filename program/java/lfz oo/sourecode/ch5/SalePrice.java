//: SalePrice.java

//package g3ds.joop.ch5;

//扩展一个类型用来设置打折定价策略
public class SalePrice extends PricePolicy{
	private double discount;
	
	public void setDiscount(double discount){
		this.discount=discount;
	}
	
	public double getPrice(){
		return basePrice*discount;
	}
}