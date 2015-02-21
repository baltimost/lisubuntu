//:Outer.java

//package g3ds.joop.ch4;

public class Outer{
	/*不可以作为Outer类的内部类
	private class InstanceInner{
		//非静态成员类不可包含静态变量
		static int k;
	}
	*/
	
	protected static class StaticInner{
		static int k;
	}
	
	/*不可以作为Outer类的内部类
	public class AnotherInstanceInner{
		//非静态成员类不可包含静态变量
		static int k;
	}
	*/
	
	public abstract class AbstractInner{
		public abstract void method();
	}
	
	public interface InterfaceInner{
		void method();
	}
}