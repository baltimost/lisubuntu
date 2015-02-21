//: PrimitiveNarrowing.java

//package g3ds.joop.ch3;

class PrimitiveNarrowing {
	public static void main(String[] args) {
		//整型数值缺省为int
		//对于byte, char, short, 在取值范围中的数值可自动转换，无需写出转换类型
		byte b=65;//相当于b=(byte)65
		char c=65;//相当于c=(char)65
		short s=65;//相当于s=(short)65
		
		//而超出其取值范围的数值，则要写出强制转换类型，否则出错
		//int->short高位将丢失:
		System.out.println("(short)0x12345678==0x" +
			Integer.toHexString((short)0x12345678));
			
		//int->byte符号和数值都有可能改变:
		System.out.println("(byte)255==" + (byte)255);//0xff(补码)=-1
				
		//int->char在取值范围之外要强制转换
		int i =35000+333*65536; //=0x14d88b8
		System.out.print("int->char:i=0x" + Integer.toHexString(i));
		c= (char)i; // =0x88b8=35000(十进制)
		System.out.println("->c="+ ((c== '\u88b8')? "0x88b8":"error")+"=" + c);
		
		i =35000-50*65536; //=0xffce88b8
		c= (char)i; // =0x88b8=35000(十进制)
		System.out.print("int->char:i=0x" + Integer.toHexString(i));
		System.out.println("->c="+ ((c== '\u88b8')? "0x88b8":"error")+"=" + c);
		
		//其它的转换也要强制写出转换类型
		System.out.println("(int)0x123456789L==0x" +
			Integer.toHexString((int)0x123456789L));
		
		//byte->char无论是否在取值范围内都要强制转换，反之亦然
		b=97;
		c=(char)b;
		System.out.println("byte->char:b=97->c=" + c);
		b=-10;//0xf6（补码）实际上是0xfffffff6(int)
		c=(char)b;
		System.out.println("byte->char:b=0xf6->c=" +((c== (char)0xfff6)?"0xfff6":"error"));

		//short->char无论是否在取值范围内都要强制转换，反之亦然
		s =32500; 
		c= (char)s; 
		//s = c; // error:要求类型转换
		System.out.println("short->char:s =32500->c=" + c);
		
		s =35000-65536; //=-30536(十进制)=-7748(十六进制原码)=0x88b8(补码)
		c= (char)s; //=0x88b8=35000(十进制)
		System.out.print("short->char:s=" + ((s== (short)0x88b8)?"0x88b8":"error"));
		System.out.println("->c=" + ((c== '\u88b8')? "0x88b8":"error")+"="+c);
				
		//浮点型转换为整型将去掉尾数:
		System.out.print("double->int: 12345.6 .. ");
		double d = 12345.6;
		System.out.println((int)d + " " + (int)(-d));
		
		//浮点数值NaN->int结果为0:
		System.out.println("(int)NaN==" + (int)Float.NaN);

		// 浮点值无穷大转换成整型值:
		float fmin = Float.NEGATIVE_INFINITY;
		float fmax = Float.POSITIVE_INFINITY;
		System.out.println("把Float NEGATIVE_INFINITY..POSITIVE_INFINITY转换成整型数值的结果：");
		System.out.println("\tlong: " + (long)fmin +
			".." + (long)fmax);
		System.out.println("\tint: " + (int)fmin +
			".." + (int)fmax);
		System.out.println("\tshort: " + (short)fmin +
			".." + (short)fmax);
		System.out.println("\tchar: " + (int)(char)fmin +
			".." + (int)(char)fmax);
		System.out.println("\tbyte: " + (byte)fmin +
			".." + (byte)fmax);
	}
}
