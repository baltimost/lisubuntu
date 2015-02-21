//: Kid.java

//package g3ds.joop.ch2;

public class Kid{
	public Kid(){
		System.out.println("I am ...");
	}
	
	public static void main(String[] args){
		Kid baby;
		int seed, times, count;
		
		//可以通过args[0]输入循环次数count
		try{
			if(args.length==0)
				times=1;
			else
				times=Integer.parseInt(args[0]);
		}catch(Exception e){
			times=1;
		}
		
		count=times;
		do{
			//迭代条件计算
			count--;
			
			//利用随机数赋给seed不同的值，使得可以转移到switch语句的不同分支
			seed=(int)(Math.random()*3);
			//switch语句中表达式的结果必须是char、byte、short或int型
			switch(seed){
				case 1: baby=new Boy();
					//如果忽略了break语句，执行
					//javac -Xswitchcheck Kid.java 将出现警告
					//warning: possible fall-through into case default:...
					break;
				
				//default分支语句可以省略，如果有的话，不一定放在最后	
				default: baby=new Kid();
					//如果忽略了break语句，执行
					//javac -Xswitchcheck Kid.java 将出现警告
					//warning: possible fall-through into case 2:...
					break;
				
				case 2: baby=new Girl();
					//最后一个break可以省略
					break;
			}
		
			//使用if语句对不同实例的行为进行判断
			if(baby instanceof Boy)
				System.out.println("I like playing football.");
			else if(baby instanceof Girl)
				System.out.println("I like singing.");
			else
				System.out.println("I like ...");
				
			System.out.println();
		}while(count>=1);//循环终止条件
	}
}

//Boy是Kid的扩展类
class Boy extends Kid{
	Boy(){
		System.out.println("I am a boy.");
	}
}

//Girl是Kid的扩展类	
class Girl extends Kid{
	Girl(){
		System.out.println("I am a girl.");
	}
}