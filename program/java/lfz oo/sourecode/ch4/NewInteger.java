
/*
public class NewInteger{
	//声明变量
  	int value;
	
	public static void main(String[] args){
		NewInteger obj1 = new NewInteger();
		obj1.value = 100;
		
		NewInteger obj2 = new NewInteger();
		obj2.value = 60;
		
		System.out.println(obj1.value == obj2.value);
	}
}


final public class NewInteger{
	//将变量设为私有
  	private int value;
	
	//利用构造方法参数对变量赋值
	public NewInteger(int value){
		this.value=value;
	}
	
	//利用intValue获取值
	public int intValue(){
		return value;
	}

	//直接仿照JDK中Integer类的equals方法设计
	public boolean equals(Object obj){
		if  (obj instanceof NewInteger){
			return value==((NewInteger)obj).intValue();
		}
		return false;
	}
	
	//用作调试，发布时去掉
	public static void main(String[] args){
		NewInteger obj1 = new NewInteger(100);
		NewInteger obj2 = new NewInteger(60);
		
		System.out.println(obj1.equals(obj2));
	}
}
*/
//*
final public class NewInteger{
	//将变量设为私有
  	private int value;
	
	//利用构造方法参数对变量赋值
	public NewInteger(int value){
		this.value=value;
	}
	
	//利用intValue获取值
	public int intValue(){
		return value;
	}
	
	//适合于同类型（需要转型）比较和不同类型比较，
	public boolean equals(Object obj){	
		try{
			//直接做转型做同类型比较
			return value==((NewInteger)obj).intValue();
		}catch(ClassCastException e){
			//利用catch子句对类型不符情况进行处理
			return false;
		}
	}
		
	//设计重载equals方法：在大多数情况下为同类型（不需要转型）比较，增加此方法以减少开销
	public boolean equals(NewInteger obj){
		return value==obj.intValue();
	}
	
	//用作调试，发布时去掉
	public static void main(String[] args){
		NewInteger obj1 = new NewInteger(100);
		NewInteger obj2 = new NewInteger(60);
		
		System.out.println(obj1.equals(obj2));
	}
}

//*/