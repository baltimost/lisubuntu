//: SwapDemo.java

//package g3ds.joop.ch4;

class Coord {
	int x;
	int y;
}

public class SwapDemo{
	static void swap(Coord a, Coord b) {
		Coord temp = new Coord();

		temp = a;
		a = b;
		b = temp;
	}

	public static void main(String[] args) {
		Coord ob1 = new Coord();
		Coord ob2 = new Coord();

		ob1.x = 10;
		ob1.y = 20;

		ob2.x = 88;
		ob2.y = 99;

		System.out.println("Original values:");
		System.out.println("ob1: " + ob1.x + ", " + ob1.y);
		System.out.println("ob2: " + ob2.x + ", " + ob2.y);

		swap(ob1, ob2);

		System.out.println("Swapped values:");
		System.out.println("ob1: " + ob1.x + ", " + ob1.y);
		System.out.println("ob2: " + ob2.x + ", " + ob2.y);
	}
}