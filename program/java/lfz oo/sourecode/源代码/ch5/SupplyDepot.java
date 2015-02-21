//: SupplyDepot.java

//package g3ds.joop.ch5;

//相关联的类设计
public class SupplyDepot{
	public void service(Refuellable obj){
		obj.refuel();
	}
	
	public static void main(String[] args){
		SupplyDepot servicer=new SupplyDepot();
		
		servicer.service(new Ship());
		servicer.service(new Car());
	}
}