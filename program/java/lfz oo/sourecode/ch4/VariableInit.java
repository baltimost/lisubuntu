//: VariableInit.java

//package g3ds.joop.ch4;

public class VariableInit{
	//声明类变量
	static int classVariable;
	//声明实例变量
	int instanceVariable;
	String str;
	
	public static void main(String[] args){
		for(int i=0; i<3; i++){
			new VariableInit().showValue(i);	
		}
	}
	
	void showValue(int argument){
		//声明局部变量，但必须显式赋值后方可被调用
		int localVariable=0;
		int showVariable;
		
		//作为方法传递的形式参数可以在方法体中直接调用
		switch(argument){
			case 0: 
				//classVariable有缺省初值，可以直接调用
				showVariable=classVariable;
				str="showVariable=classVariable="+showVariable;
				break;
			
			case 1: 
				//instanceVariable有缺省初值，可以直接调用
				showVariable=instanceVariable;
				str="showVariable=instanceVariable="+showVariable;
				break;
				
			case 2: 
				// 如果localVariable没有赋值，将报错：
				//    variable localVariable might not have been initialized
				showVariable=localVariable;
				str="showVariable=localVariable="+showVariable;
				break;
		}
		
		System.out.println(str);
	}
}