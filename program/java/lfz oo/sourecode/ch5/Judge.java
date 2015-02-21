//:Judge.java

//package g3ds.joop.ch5;

//定义一个接口，其中用直观的名词替代枯燥的数字
interface SharedConstants {
	//定义3个常量分别表示石头、剪刀、布
	int STONE=0;
	int SCISSORS=1;
	int CLOTH=2;
	
	//定义3个常量分别表示不同的结果
	int LOSE=-1;
	int NOUGHT = 0;
	int WIN = 1;
}

//定义一个游戏者类
class Player implements SharedConstants {
	//模拟游戏者出拳，石头、剪刀、布任选一个
	int play() {
		int prob = (int) (3 * Math.random());
		if (prob == 0)
			return STONE;
		else if (prob == 1)
			return SCISSORS;
		else
			return CLOTH;
	}
	
	//模拟和参与游戏的对方一起判断谁输谁赢
	int compare(Player gambler){
		//自己出拳
		int mySign=play();
		switch(mySign){
			case(STONE):
				System.out.print(" 石  头");
				break;
			case(SCISSORS):
				System.out.print(" 剪  刀");
				break;
			case(CLOTH):
				System.out.print("     布");
				break;
		}
		
		//对方也出拳
		int yourSign=gambler.play();
		switch(yourSign){
			case(STONE):
				System.out.print(" :  石  头 ");
				break;
			case(SCISSORS):
				System.out.print(" :  剪  刀 ");
				break;
			case(CLOTH):
				System.out.print(" :  布     ");
				break;
		}
		
		//判断输赢
		if ((mySign==STONE && yourSign==SCISSORS) || 
			(mySign==SCISSORS && yourSign==CLOTH) || 
			(mySign==CLOTH && yourSign==STONE)){
			System.out.println("\t ＝》     赢 : 输");
			return WIN;
		}
		else if((yourSign==STONE && mySign==SCISSORS) || 
			(yourSign==SCISSORS && mySign==CLOTH) || 
			(yourSign==CLOTH && mySign==STONE)){
			System.out.println("\t ＝》     输 : 赢");
			return LOSE;
		}
		else{
			System.out.println("\t ＝》     无   效");
			return NOUGHT;
		}
	}
}

//定义一个裁判员类，模拟三胜两游戏
public class Judge implements SharedConstants {
	public static void main(String[] args) {
		int count=0;
		int win=0;
		int lose=0;
		
		Player banker = new Player();
		Player gambler = new Player();
		
		System.out.println("\"石头.剪刀.布\"游戏: 三胜两");
		System.out.println("大头儿子:小头爸爸\t ＝》大头儿子:小头爸爸");
		
		for(; ; ){
			//记录出拳总次数
			count++;
			
			//比较输赢
			int i=banker.compare(gambler);
			if(i==WIN)
				win++;
			else if(i==LOSE)
				lose++;
				
			//退出循环的条件
			if((win+lose)>=3) break;
		}
		
		System.out.println("总共出拳 "+count+" 次");
		System.out.println("结果："+((win>lose)?"大头儿子":"小头爸爸")+" 胜");
	}
}