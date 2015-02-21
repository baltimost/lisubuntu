//: InitializationDemo.java

//package g3ds.joop.ch4;


/*
public class InitializationDemo{
	static String str="aaa ";
		
	static{
		System.out.print(str);	
		System.out.print("bbb ");
	}

	InitializationDemo(){
		str="ccc ";
		System.out.print(str);
	}
	
	public static void main(String[] args){
		System.out.print(str);
	}
}



public class InitializationDemo{
	static String str="aaa ";
		
	InitializationDemo(){
		str="ccc ";
		System.out.print(str);
	}
	
	{
		System.out.print(str);	
	}
		
	public static void main(String[] args){
		InitializationDemo obj = new InitializationDemo();
		System.out.print(obj.str);
		
		System.out.print(str);
	}
}



public class InitializationDemo{
	int score = 100;
		
	public String isExcellent(){
		String result;
		
		if(score>=90)
			result = "Very very good!";
			
		return result;
	}
	
	public static void main(String[] args){
		InitializationDemo obj = new InitializationDemo();
		System.out.print(obj.isExcellent());
	}
}

//*/

public class InitializationDemo{
	public static void main(String[] args){
		ThisDemo obj = new ThisDemo();
		
		System.out.print(((SuperDemo)obj).str);
	}
}

class SuperDemo{
	String str = "In Super.";
}

class ThisDemo extends SuperDemo{
	String str = "In This.";
}