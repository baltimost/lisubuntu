//: PassByRef.java

//package g3ds.joop.ch4;

public class PassByRef{
	public static void main(String[] agrs){
		String str1=new String("abc");
		String str2=new String("123");
		
		PassByRef byRef=new PassByRef();

		System.out.println("str1 before swap method: "+str1);
		System.out.println("str2 before swap method: "+str2);
		
		byRef.swap(str1, str2);
		
		System.out.println("str1 after swap method: "+str1);
		System.out.println("str2 after swap method: "+str2);
	}
	
	void swap(String str1, String str2){
		String temp=str1;
		str1=str2;
		str2=temp;
		System.out.println("str1 in swap method: "+str1);
		System.out.println("str2 in swap method: "+str2);
	}
}