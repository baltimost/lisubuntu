//: StringConvention.java

//package g3ds.joop.ch5;

public class StringConvention{
	public static void main(String agrs[]){
		String a1="test";
		String b1="test";

		/* String对象的hashCode的算法如下： 
		 * s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
		 * 其中，s[i]是字符串中该位置字符ASCII(UNICODE)所代表的
		 * 整数值: n是字符串的长度,  ^ 表示幂.
		 * (空字符串的hashCode值为0)
		 */

		//65*(31^3+32^2+31+1)=2000960
		b1="AAAA";
		System.out.println("(AAAA)的散列码= "+b1.hashCode());

		//b1=""的hashCode值为0,并不是b1=null
		b1="";
		System.out.println("(空字符串)的散列码= "+b1.hashCode());
		
		//将引发异常
		//b1=null;
		//System.out.println("(null)的散列码= "+b1.hashCode());

		//116*31^3+101*31^2+115*31+116=3556498
		b1=new String("test");
		System.out.println("a1:(test)的散列码= "+a1.hashCode());
		System.out.println("b1:(test)的散列码= "+b1.hashCode());
	
		//对象本身比较和内容比较
		System.out.println("相同内容：a1.eauals(b1)= "+a1.equals(b1));
		System.out.println("(不同对象：a1==b1)= "+(a1==b1));
		
		//利用System类identityHashCode方法调用覆盖前的散列码
		System.out.println("覆盖前a1:(test)的散列码= "+
				System.identityHashCode(a1));
		System.out.println("覆盖前b1:(test)的散列码= "+
				System.identityHashCode(b1));

		//在StringBuffer类中并没有覆盖hashCode()
		System.out.println("\n对比：StringBuffer类中并没有覆盖hashCode方法");
		StringBuffer aa=new StringBuffer("test");
		StringBuffer bb=new StringBuffer("test");
		System.out.println("aa：(test)的散列码= "+aa.hashCode());
		System.out.println("bb：(test)的散列码= "+bb.hashCode());
		
		//同一个对象被改造，hashCode一致
		bb.insert(4, "!changed");
		System.out.println("bb：(test!changed)的散列码= "+bb.hashCode());
	}
}