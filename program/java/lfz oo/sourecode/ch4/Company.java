//: Company.java

//package g3ds.joop.ch4;

public class Company{
	//声明为final的成员必须显式初始化，否则报错：
	//  variable COMPANY_NAME might not have been initialized
	private static final String COMPANY_NAME="开封府";
	
	public static void main(String[] args){
		/*
		  声明局部变量
		  注意！局部变量不能添加访问权限修饰符，否则报错：
		      illegal start of expression
		*/
		String output = "招聘单位：" + getCompanyName() + 
			"\n招聘前公司雇员总数: " +Employee.getCount();

		// 招聘新雇员
		Employee e = new Employee( "拯", "包" );//e是一个对象引用变量
		output += "\n新进雇员: " + e.getLastName() + " " +
			 e.getFirstName() + "; 他说他的公司雇员总数 = " + 
			 e.getCount() ;//通过雇员了解到公司信息
		Employee e1 = new Employee( "朝", "王" );//e1是一个对象引用变量
		output += "\n新进雇员: " + e1.getLastName() + " " +
			 e1.getFirstName() + "; 他说他的公司雇员总数 = " + 
			 e1.getCount() ;//通过雇员了解到公司信息
		Employee e2 = new Employee( "汉", "马" );//e2是一个对象引用变量
		output += "\n新进雇员: " + e2.getLastName() + " " +
			 e2.getFirstName() + "; 他说他的公司雇员总数 = " + 
			 e2.getCount() ;//通过雇员了解到公司信息
   
		// 通过其它渠道了解公司信息（利用类调用类方法）
		output += "\n从公司主页访问到公司雇员总数: " + Employee.getCount();
   
		// 有一个雇员离职，岗位空出
		e1 = null;  
		output += "\n\n公司有人离职！…… ";
		
		// 在本例中，“王朝”这个对象已不再被引用，可以被清除
		// System.gc()这个方法用来清除不再被引用的对象，但它的优先级较低，
		// 一般情况会清除掉该对象，但不是绝对的，详见4.4"对象清除"
		System.gc(); 
		
		output += "\n公司主页更新后的雇员总数: " + Employee.getCount();

		System.out.println(output);
	}
	
	//此方法声明为final,不可再被重写
	public static final String getCompanyName(){
		return COMPANY_NAME;
	}
}