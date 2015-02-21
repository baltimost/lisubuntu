//: RTTIDemo.java

//package g3ds.joop.ch5;

public class RTTIDemo{
  public static void main(String args[]) {
    X x = new X();
    Y y = new Y();
    Class clObj;

	//获得y对象的Class对象引用
    clObj = y.getClass(); 
    System.out.println("y is object of type: "+clObj.getName());
    
    //获得y对象超类的Class对象引用
    clObj = clObj.getSuperclass();
    System.out.println("y's superclass is "+ clObj.getName());
    
    //获得x对象的Class对象引用
    clObj = x.getClass();
    System.out.println("x is object of type: "+clObj.getName());
	
	//获得x对象超类的Class对象引用
    clObj = clObj.getSuperclass();
    System.out.println("x's superclass is "+ clObj.getName());
    
    //测试Object类的超类
    System.out.println("Object's superclass is "+ clObj.getSuperclass());
  }
}

class X {}

class Y extends X {}