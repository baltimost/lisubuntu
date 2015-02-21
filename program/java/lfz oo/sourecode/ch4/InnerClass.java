//: InnerClass.java
/*: 总共包含12个类,分别是
	1个接口： AnonymousInner.class
	2个外部类： InnerClass.class、UsingInnerClass.class
	1个静态成员类： InnerClass$StaticInner.class
	1个实例成员类： InnerClass$InstanceInner.class
	5个局部成员类： InnerClass$1$NestInner.class、InnerClass$1$MultiNest.class、
		InnerClass$1$NestInner$MultiNest.class、 InnerClass$1$ScopeInner.class
		InnerClass$2$MultiNest.class
	2个匿名类：InnerClass$1.class、InnerClass$2.class
*/

//package g3ds.joop.ch4;

//此类被编译成 InnerClass.class
public class InnerClass{
	
	/*
	//可以把内部类声明为外部类的静态或非静态成员变量
	static StaticInner si=new StaticInner();
	//对于实例成员类不能直接声明为static
	//static InstanceInner ii1=new InstanceInner();//It is wrong
	InstanceInner ii1=new InstanceInner();//It is ok
	//但先创建外部类实例后可以声明为static
	static InstanceInner ii2=new InnerClass().new InstanceInner();
	*/
	
	//外部类的实例变量
	int varTest=0;
	
	//静态成员类：此类被编译成 InnerClass$StaticInner.class
	static class StaticInner{
		StaticInner(){
			System.out.println("Show me: StaticInner");

		}
	}
	
	//实例成员类：此类被编译成 InnerClass$InstanceInner.class
	class InstanceInner{
		//定义一个与外部类的实例变量同名的内部类变量
		int varTest=5;
		
		void doSomething(){
			//在方法中进一步定义同名的局部变量
			int varTest=10;
			
			System.out.println("Show me: InstanceInner");
			
			System.out.println("同名变量的访问方法测试:");
			
			//varTest:局部变量
			System.out.println("varTest in InstanceInner(): " + varTest);
			
			//this.varTest:同名的内部类变量
			System.out.println("varTest in Inner class: " + this.varTest);
			
			//InnerClass.this.varTest:同名的外部类的变量
			System.out.println("varTest in outer class: " + InnerClass.this.varTest);
		}
	}
	
	//定义一个包含局部成员类的实例方法，并把局部成员类的引用值返回
	public Object nestTest(){
		//在局部成员类中使用的局部变量必须声明为final型
		final int VARTEST=100;
		
		//内部类可以有独立的继承关系或实现自己的接口,
		//此类被编译成 InnerClass$1$NestInner.class
		class NestInner extends InstanceInner implements AnonymousInner{
			NestInner(){
				//此类被编译成 InnerClass$1$MultiNest.class
				class MultiNest{}
				
				System.out.println("Show me: NestInner");
				
				//VARTEST: 声明为final型的局部变量
				System.out.println("calling varible beyond the scope: " + VARTEST);
			}
			
			//此类被编译成 InnerClass$1$NestInner$MultiNest.class
			class MultiNest{}
		}
		
		//返回一个局部成员类对象
		return new NestInner();
	}
	
	public void scopeTest(boolean condition){
		if(condition){
			//在一个语句中定义一个局部成员类,此类被编译成 InnerClass$1$ScopeInner.class
			class ScopeInner{
				ScopeInner(){
					//此类被编译成 InnerClass$2$MultiNest.class
					class MultiNest{}
					System.out.println("Show me: ScopeInner");
				}
			}
			new ScopeInner();
		}
	}
	
	public void anonymousTest(){
		//此处定义一个匿名类，可能被编译成InnerClass$1.class
		new AnonymousInner(){
			//作为实例代码块
			{
				//匿名类中还可以定义匿名类，"="右边可能被编译成InnerClass$2.class
				Object obj=new AnonymousInner(){};
				
				System.out.println("Show me: AnonymousInner");
			}		
		//结尾处的“;”不可少！
		};
	}

	public static void main(String[] args){
		System.out.println("各种形式的内部类测试：");
		
		//创建相应的外部类实例对象
		InnerClass innerClass=new InnerClass();
		
		//静态成员类可以直接实例化
		StaticInner staticInner=new StaticInner();
		
		//非静态成员类需先生成外部类实例
		InstanceInner instanceInner=innerClass.new InstanceInner();
			instanceInner.doSomething();
		innerClass.nestTest();
		innerClass.scopeTest(true);
		innerClass.anonymousTest();
	}
}

//模拟事件监听器，定义一个接口
//此接口被编译成 AnonymousInner.class
interface AnonymousInner{}

//使用其它外部类的内部类的方式,此类被编译成 UsingInnerClass.class
class UsingInnerClass{
	public static void main(String[] args){
		//不能直接以编译出来的类名实例化：下面一行声明方式是错误的 ！
		//InnerClass$StaticInner icsi=new InnerClass$StaticInner();
		
		//静态成员类可以直接实例化
		InnerClass.StaticInner icsi=new InnerClass.StaticInner();
		
		//非静态成员类需先生成外部类实例
		InnerClass.InstanceInner icii=new InnerClass().new InstanceInner();
		icii.doSomething();
	}
}