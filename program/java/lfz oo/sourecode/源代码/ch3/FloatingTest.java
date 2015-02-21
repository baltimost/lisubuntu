//: FloatingTest.java

//package g3ds.joop.ch3;

class FloatingTest {
	public static void main(String[] args) {	
		// NaN举例
		double d = 0.0/0.0;
		System.out.println("0.0/0.0 is Not-a-Number: "+d);

		double x1= 0.0/0.0;
		double x2= 0.0/0.0;
		System.out.println("当x1和x2都是NaN时，");
		System.out.println("(x1==x2): " + (x1==x2));
		System.out.println("(x1<x2): "+ (x1<x2));
		System.out.println("(x1<x2)==!(x1>=x2): "+ ((x1<x2)==!(x1>=x2)));
		
		// 浮点运算的非精确性举例
		System.out.println("\n浮点运算的非精确性举例:");
		float f=0.0f; 
		for (int i=0;i<10;i++) {
			f+=0.1f;
		}
		System.out.println("若f=0.0f，执行10次f=f+0.1f所得到的结果是:"+ f);	
		
		// 浮点运算的非精确性的另一个例子		
		System.out.println("令int i=0～99，执行z/i*i后与理论值z不符的例子：");
		System.out.println("对于不同的z值结果不同，本例取z=55.0");
		System.out.print("\t对于单精度运算：");
		for (int i = 0; i < 100; i++) {
			float z = 55.0f / i * i;
			if (z != 55.0f)
				System.out.print(" " + i);
		}
		System.out.println();

		System.out.print("\t对于双精度运算：");
		for (int i = 0; i < 100; i++) {
			double z = 55.0 / i * i;
			if (z != 55.0)
				System.out.print(" " + i);
		}
		System.out.println();
	}
}