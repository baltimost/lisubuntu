//: ValueScope.java

//package g3ds.joop.ch3;

public class ValueScope{
	public static void main(String[] args){
		//声明变量
		byte b;
		char c;
		short s;
		int i;
		long l;
		float f;
		double d;
		
		/*
		// 直接赋值越界情形：编译时将报错
		// 以下三行将引发error: possible loss of precision
		b=130;//或者取-130
		c=70000;//或者取-70000
		s=40000;//或者取-40000
		
		// 以下两行将引发error: integer number too large
		i=3000000000;//或者取-3000000000
		l=9223372036854775809L;//或者取-9223372036854775809L
		
		// 以下两行将引发error: floating point number too large
		f=4.0e50f;//或者取-4.0e50f
		d=2.0e325;//或者取-2.0e325
		
		// 以下两行将引发error: floating point number too small
		f=4.0e50f;//或者取-4.0e50f
		d=2.0e325;//或者取-2.0e325
		*/
		
		int factor=2;//作为使运算后的数值结果越界的因子
		String str="factor=2\n";//存储需要打印的结果
			
		//整型数将去掉溢出部分，然后剩下部分即为补码
		//以下注释中的数值均用十六进制补码形式的机器数
		b=(byte)(-0xf0*factor);//结果为：0XE0
		str+="(byte)(-0xf0*factor)="+b+"\n";
		
		c=(char)(0xf000*factor);//结果为：0XE000
		str+="(char)(0xf000*factor==\'\\uE000\')="+(c=='\uE000')+"\n";
		
		s=(short)(0xf000*factor);//结果为：0XE000
		str+="(short)(0xf000*factor)="+s+"\n";
		
		i=0xf0000000*factor;//结果为：0XE0000000
		str+="0xf0000000*factor="+i+"\n";
		
		l=0xf000000000000000L*factor;//结果为：0XE000000000000000
		str+="0xf000000000000000L*factor="+l+"\n";
				
		
		//浮点型对于所有的数值都可进行处理
		f=-3.0e38f*factor;//结果为：-Infinity
		str+="-3.0e38f*factor="+f+"\n";
		
		f=-1.0e-45f/factor;//结果为：-0.0
		str+="-1.0e-45f/factor="+f+"\n";
				
		d=4.9e-324/factor;//结果为：0.0
		str+="4.9e-324*factor="+d+"\n";
				
		d=1.7e308*factor;//结果为：Infinity
		str+="1.7e308*factor="+d+"\n";
			
		f=-1.0e-45f/0;//结果为：-Infinity
		str+="-1.0e-45f/0="+f+"\n";
		
		d=4.9e-324/0;//结果为：Infinity
		str+="4.9e-324/0="+d+"\n";
		
		System.out.print(str);
		
		
		//附带说明：以下语句将引发异常
		try{
			//先运算后赋值！所以无论“=”左边的变量为何种类型，
			//在做算术运算时，数值0作为整数处理。而整数除以0运算将引发异常
			d=50/0;
		}catch(ArithmeticException e){
			System.out.println("整数算术运算50/0引发异常："+e.toString());
		}
		
	}
}