//: Rectangle.java

//package g3ds.joop.ch5;

class Square extends Rectangle{
	public Square(double s){
		super(s, s);
	}
	
	//由于继承的方法是不可选择的，因此只能改写setWidth和
	//setHeight方法，使之满足正方形边长相等的要求。
	public void setWidth(double w){
		super.setWidth(w);
		super.setHeight(w);
	}
	
	public void setHeight(double h){
		super.setWidth(h);
		super.setHeight(h);
	}
}