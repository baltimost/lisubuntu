//: CharacterExpression.java
//: 字符的表达方式

//package g3ds.joop.ch3;

public class CharacterExpression{
	public static void main(String[] args){
		// 单个字符表示
		char c1='A';
		// 八进制转义表示,可用1到3位数字,此处为";"
		char c2='\73';
		// 转义字符,此处为Tab键
		char c3='\t';
		// Unicode转义表示,需用4位数字,此处为"A"
		char c4='\u0041';

		System.out.print(c1);
		System.out.print(c2);
		System.out.print(c3);
		System.out.print(c4);
		System.out.println();
       	
		// 'A'+'\73'+'\t'+'\u0041'相当于数值相加:65+59+9+65=198
		System.out.println(c1+c2+c3+c4);
		// 'A'+'\73'+'\t'+'\u0041'位置在前,则作为整数值运算,再和"Hello"连接
		System.out.println(c1+c2+c3+c4+"Hello");
		// 'A'+'\73'+'\t'+'\u0041'位置在后,则直接作为字符连接
		System.out.println("Hello"+c1+c2+c3+c4);
		
		String str="Hello";
		int i=1;
		double d=0.11;
		// 第一个"+"为加号,可换为其它算术运算符如"-"、"*"等;第二个"+"为连接符,不可替换
		System.out.println(i+d+str);
		// 两个"+"均为连接符,不可替换
		System.out.println(str+i+d);
	}
}