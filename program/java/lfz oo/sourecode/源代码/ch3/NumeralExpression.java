//: NumeralExpression.java
//: 不同进制的表示

//package g3ds.joop.ch3;

public class NumeralExpression{
	public static void main(String[] args){
       int decimal = 65;
       int octal = 0101;
       int hexadecimal = 0x41;
       
       System.out.println("十进制数: "+ decimal);
       System.out.println("八进制0101对应的十进制数: "+ octal);
       System.out.println("十六进制0x41对应的十进制数: " + hexadecimal);
	}
}
