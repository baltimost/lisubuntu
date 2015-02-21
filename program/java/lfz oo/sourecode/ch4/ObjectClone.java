//: ObjectClone.java

//package g3ds.joop.ch4;

public class ObjectClone{
	public static void main(String[] args){
		MyObject obj=new MyObject("Original MyObject!");
		
		System.out.println("方法调用前原来对象的属性："+obj.name);
		
		new ObjectClone().passByReference(obj);
		
		System.out.println("方法调用后原来对象的属性："+obj.name);
	}
	
	void passByReference(MyObject obj){
		MyObject o=(MyObject)obj.clone();
		o.name="MyObject Clone!";
		System.out.println("方法体中改变了复制对象的属性："+o.name);
	}
}

class MyObject implements Cloneable{
	String name;
	
	MyObject(String name){
		this.name=name;
	}
	
	//重写clone方法
	public Object clone(){
		Object obj=null;
		
		try{
			obj=super.clone();
		}
		catch(CloneNotSupportedException e){
			System.err.println(e);
		}
		
		return obj;
	}
}