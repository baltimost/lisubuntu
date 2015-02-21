//: BitOperand.java

//package g3ds.joop.ch3;

public class BitOperand{
	public static void main(String[] args){
		boolean b1=true, b2=false;
		System.out.println("若有布尔型数：b1=true, b2=false，布尔逻辑运算结果：");
		System.out.println("  b1 & b2 = " + (b1 & b2));
		System.out.println("  b1 | b2 = " + (b1 | b2));
		System.out.println("  b1 ^ b2 = " + (b1 ^ b2));
		
		int a,a1,b,r,s,t,t1,w,w1,x,y,x1,z,z1;

		a = 22; 	//int为32位  0000 0000 0000 0000 0000 0000 0001 0110
		a1 = -22; 	//int为32位  1000 0000 0000 0000 0000 0000 0001 0110
					//反码       1111 1111 1111 1111 1111 1111 1110 1001
					//补码       1111 1111 1111 1111 1111 1111 1110 1010
		b = 3; 		//int为32位  0000 0000 0000 0000 0000 0000 0000 0011
		System.out.println("若有整型数：a = 22，a1 = -22，b = 3");

		//按位逻辑运算
		r = a & b; // a & b ＝ 0000 0000 0000 0000 0000 0000 0000 0010 ＝ 2
		s = a | b; // a | b ＝ 0000 0000 0000 0000 0000 0000 0001 0111 ＝ 23
		y = a ^ b; // a ^ b ＝ 0000 0000 0000 0000 0000 0000 0001 0101 ＝ 21
		System.out.println("按位逻辑运算");
		System.out.println("  按位与结果：a & b = " + r);
		System.out.println("  按位或结果：a | b = " + s);
		System.out.println("  按位异或结果：a ^ b = " + y);

		//按位取反
		z = ~ a; 	// ~a = 1111 1111 1111 1111 1111 1111 1110 1001（补码）＝－23
		z1 = ~ a1; 	// ~ a1 = 0000 0000 0000 0000 0000 0000 0001 0101 = 21
		System.out.println("按位取反");
		System.out.println("  按位取反结果：~ a = " + z);
		System.out.println("  按位取反结果：~ a1 = " + z1);
       
		//按位左移运算<<：正数左移低位补0，负数左移也是低位补0
		t = a << b; 	// a << b = 0000 0000 0000 0000 0000 0000 1011 0000 = 176
		t1 = a1 << b; 	// a1 << b = 1111 1111 1111 1111 1111 1111 0101 0000 = －176
		System.out.println("按位左移运算<<");
		System.out.println("  按位左移结果：a << b = " + t);
		System.out.println("  按位左移结果：a1 << b = " + t1);
       
		//按位右移运算>>应考虑符号：正数右移高位补0，负数右移高位补1
		w = a >> b; 	// a >> b = 0000 0000 0000 0000 0000 0000 0000 0010 = 2
		w1 = a1 >> b; 	// a1 >> b = 1111 1111 1111 1111 1111 1111 1111 1101（补码） = -3
		System.out.println("按位右移运算>>");
		System.out.println("  按位右移结果：a >> b = " + w);
		System.out.println("  按位右移结果：a1 >> b = " + w1);

		//按位右移运算>>>不考虑符号：正数和负数右移高位均补0
		x = a >>> b; 	// a >>> b = 0000 0000 0000 0000 0000 0000 0000 0010 = 2
		x1 = a1 >>> b; 	// a1 >>> b = 0001 1111 1111 1111 1111 1111 1111 1101 = 536870909
		System.out.println("按位右移运算>>>");
		System.out.println("  按位右移结果：a >>> b = " + x);
		System.out.println("  按位右移结果：a1 >>> b = " + x1);

		//移位运算时，移动位数根据相应类型位数先取模后运算
		b = 3 + 5 * 32;
		x = a >>> b; 	// a >>> b = 0000 0000 0000 0000 0000 0000 0000 0010 = 2
		x1 = a1 >>> b; 	// a1 >>> b = 0001 1111 1111 1111 1111 1111 1111 1101 = 536870909
		System.out.println("移位运算时，b ＝ 3 + n * 32 的结果与 b ＝ 3 一样：");
		System.out.println("  按位右移结果：a >>> b = " + x);
		System.out.println("  按位右移结果：a1 >>> b = " + x1);
	}
}