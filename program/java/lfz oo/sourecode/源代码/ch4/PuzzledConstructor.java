//: PuzzledConstructor.java

//package g3ds.joop.ch4;

public class PuzzledConstructor{
	public static void main(String[] args){
		//测试一下看看
		new PuzzledConstructor();
	}
	
	/*
	  这是一个伪构造方法，实际上是一个与构造方法同名的实例方法
	  这种失误往往发生在刚好把类名改成和原来的某个方法名一样，
	  而又没有修改相应的一些程序。
	  当然也和编程命名不规范有关，比如遵循方法名以小写字母开始等等……
	  调试时如果这根弦恰好没有接上，那就苦哇！！
	*/
	void PuzzledConstructor(){
		System.out.println("伪构造方法！");
	}
	
	//这才是真的构造方法
	PuzzledConstructor(){
		System.out.println("真构造方法！");
	}
}