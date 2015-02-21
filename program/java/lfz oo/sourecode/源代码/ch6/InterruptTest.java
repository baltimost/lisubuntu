//: InterruptTest.java

//package g3ds.joop.ch6;

public class InterruptTest{
	public static void main(String[] args){
		//创建外部类实例
		InterruptTest obj=new InterruptTest();
		
		//有意参加面试者
		Interviewee p1 = obj.new Interviewee("张三");
		Interviewee p2 = obj.new Interviewee("李四");
		Interviewee p3 = obj.new Interviewee("王老五");
		Interviewee p4 = obj.new Interviewee("吴小丫");
		
		//通知面试人选
		Interviewee[] persons={p1, p3, p4};
		
		//主考官及其欲面试人员
		Interviewer p = obj.new Interviewer("赵公明", persons);
		
		//开始选人
		p.start();
	}
	
	//设计一个扩展Thread的内部类，代表面试者
	private class Interviewee extends Thread{
		//记录是否被选中的状态
		private boolean isNodded;
		
		//设计传递实例名的构造方法
		Interviewee(String name){
			super(name);
		}
		
		//覆盖父类的run方法
		public void run(){
			try{			
				//面试者的情景会话
				answer();
				
				//模拟进一步交流过程花费的时间和具体做的事，
				//如果没有或设置太短，可能被中断的线程也会继续执行下去！
				Thread.sleep(1000);
				
				System.out.println("更加深入的交流，正在面试中...");
				System.out.println("谢谢！");
			}catch(InterruptedException e){}
		}
		
		//检测是否被选中
		boolean isNodded(){
			return isNodded;
		}
		
		//设置是否被选中
		void setNodded(boolean isNodded){
			this.isNodded=isNodded;
		}
		
		//模拟面试者的回答
		void answer(){
			if(isNodded)
				System.out.println("我叫"+ getName() + "，名字通俗易记，"+
						"为人随和，善于和客户沟通。而且...");
			else
				System.out.println("我叫"+ getName() + "，我...?");
		}
	}
	
	//设计一个扩展Thread的内部类，代表主考官
	private class Interviewer extends Thread{
		//主考的面试者
		private Interviewee[] persons;
		
		//设计传递实例名的构造方法
		Interviewer(String name, Interviewee[] persons){
			super(name);
			this.persons=persons;
		}
		
		//覆盖父类的run方法
		public void run(){
			try{
				for(int i=0; i<persons.length; i++){
					//开始面试
					persons[i].start();
					
					//主考官的意见
					interview(persons[i]);
								
					//模拟面试完一个人以后才能继续下一个
					persons[i].join();
					
					System.out.println();
				}
			}catch(InterruptedException e){}
		}
		
		//模拟面试过程
		void interview(Interviewee person){
			//主考官的意见
			decide(person);
				
			//主考官的委婉措词
			if(!(person.isNodded())){
				System.out.println("对不起，我们感情趣的是...");
				
				//不符条件的面试者将尽快退场
				person.interrupt();
			}
			else{
				System.out.println("请介绍一下你的情况。");
			}
		}
		
		//模拟主考官对面试者的判定
		private void decide(Interviewee person){
			//用一个随机数决定面试者的命运，看起来有些草率！
			int seed=(int)(Math.random()*2);

			switch(seed){
				case 0:
					person.setNodded(false);
					break;
				case 1:
					person.setNodded(true);
					break;
			}
		}
	}
}