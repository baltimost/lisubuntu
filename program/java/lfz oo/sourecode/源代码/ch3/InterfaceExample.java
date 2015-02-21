//: InterfaceExample.java

//package g3ds.joop.ch3;

interface BaseColors {
	int RED=1, GREEN=2, BLUE=4;
}

interface RainbowColors extends BaseColors {
	int YELLOW=3, ORANGE=5, INDIGO=6, VIOLET=7;
}

interface PrintColors extends BaseColors {
	int YELLOW=8, CYAN=16, MAGENTA=32;
}

// 接口类型可以进行多重继承
interface LotsOfColors extends RainbowColors, PrintColors {
	// 所有成员属性都是常量
	int FUCHSIA=17, VERMILION=43, CHARTREUSE=RED+90;
	// 所有的成员方法都是抽象的
	void mix(int[] colors);
	// 可以声明成员接口
	interface Brush{
		int LARGE=100, MIDDLE=50, SMALL=1;
	}
	//也可以声明成员类
	class Tool implements Brush{
		// 在这里定义类体 
	}
}

public class InterfaceExample implements LotsOfColors{
	// 在类中要实现相应接口的方法
	public void mix(int[] colors){}
	// 因为多重继承引起成员同名歧义时，应明确指出具体的来源
	public static void main(String[] args){
		System.out.println(PrintColors.YELLOW);
	}
}