//: TestLSP.java

//package g3ds.joop.ch5;

public class TestLSP{
	//设计一个方法用来测试所设计的类是否满足LSP法则
	//方法所传递的参数是Rectangle型
	static void testLSP(Rectangle r){
		//测试时如果输入两个不同值，则输出结果是类型敏感的
		//也就是说，我们只有知道具体的类型，才能知道具体结果，
		//这违背了LSP法则
		r.setWidth(4.0)	;
		r.setHeight(5.0);
		
		System.out.print("矩形长 "+ r.getWidth());
		System.out.print("，矩形宽 "+ r.getHeight());
		System.out.println("，面积 "+r.area());
	}
	
	public static void main(String[] args){
		//当实参类型为Rectangle时，结果为20
		testLSP(new Rectangle(1.0, 1.0));
		
		//当实参类型为Square时，结果为25
		testLSP(new Square(1.0));
	}
}