//: Employee.java

//package g3ds.joop.ch4;

// 设计Employee类
public class Employee{
	//为了更好地封装类，把以下变量都声明为私有的
	//设计一个变量用来记录雇员总数，对公司的每个员工数据应该是一致的，因此声明为类变量
	private static int count; 

	//记录雇员的个人信息，应由每个雇员独自拥有，因此声明为实例变量
	private String firstName;
	private String lastName;

	//设计构造方法的参数（局部变量），用来传递新雇员的个人信息
	public Employee( String firstName, String lastName ){
		//当招聘一名雇员时，记录其个人信息
		//局部变量名可以和实例变量名相同，使用时利用this关键字指明实例变量
		this.firstName = firstName;
		this.lastName = lastName;

		//并把公司雇员总数自动加1
		++count; 
	}

	//重写Object类中的finalize()方法（在对象被清除时自动调用）
	protected void finalize(){
		//使得有雇员离职时，公司雇员总数自动减1
		--count; 
	}

	//通过方法设计，把雇员个人信息设为“只读”
	public String getFirstName(){ 
		return firstName; 
	}

   	public String getLastName(){ 
		return lastName; 
	}

	// 把公司雇员总数信息设为“只读”，因为count为类变量，
	// 因此也把本方法设为类方法，以便于对等访问
	public static int getCount(){ 
		return count; 
	} 
}