//: AccountSimulator.java

//package g3ds.joop.ch6;

public class AccountSimulator{
	//声明2个帐户
	protected CustomerAccount savings;
	protected CustomerAccount checking;
	
	public static void main(String[] args){
		//预先分别存入1000元，或者通过参数设置
		int transfers= 1000;
		try{
			transfers=Integer.parseInt(args[0]);
		}catch(Exception e){}
		
		//开始模拟
		AccountSimulator am=new AccountSimulator(transfers);
	}
	
	//模拟器的构造方法
	public AccountSimulator(int transfers){
		//启用2个帐户
		savings=new CustomerAccount(transfers);
		checking=new CustomerAccount(transfers);
		
		
		/*以下模拟有两个人同时在2个帐户间转帐*/
		TransferManager tm1=new TransferManager(checking, savings);
		TransferManager tm2=new TransferManager(savings, checking);
		
		Thread t1=new Thread(tm1);
		Thread t2=new Thread(tm2);
		
		t1.start();
		t2.start();
		
		//直到2个线程执行完毕继续以后语句
		try{
			t1.join();
			t2.join();
		}catch(Exception e){}
		
		//输出钱的格式化表示
		java.text.NumberFormat formatter=
			java.text.NumberFormat.getCurrencyInstance(
			java.util.Locale.CHINA);
		
		System.out.println("转帐之前两帐户的总余额: "+
			formatter.format(transfers*2));

		System.out.println("转帐之后两帐户的总余额: "+
			formatter.format(savings.getBalance()+
			checking.getBalance()));
	}
}


//模拟转帐的过程
class TransferManager implements Runnable{
	//声明2个帐户
	protected CustomerAccount fromAccount;
	protected CustomerAccount toAccount;
	
	//转帐计数
	protected volatile int transferCount;
	
	//定义一个静态对象充当对象锁，供同步设计时使用
	private static Object obj=new Object();	
		
	public TransferManager(CustomerAccount from, CustomerAccount to){
		this.fromAccount=from;
		this.toAccount=to;
	}
	
	//实现run方法	
	public void run(){
		//声明几个局部变量
		double balance;//余额
		double transferAmount;//转帐次数
		
		while( transferCount<8){
			/*设计同步的对象锁可用类本身或静态对象*/
			//注意类对象锁的定义方式！
			//synchronized(TransferManager.class){
			//或者
			synchronized(obj){
			
			/*但此处使用实例对象锁无效，因为本类实现了Runnable接口，
			  线程分别对应不同的对象*/
			//synchronized(this){
				
				//从一个帐户获得余额信息
				balance=fromAccount.getBalance();
							
				//确定转帐额度：最高为余额的一半，使得帐户中不会为空
				transferAmount=(int)(balance*Math.random()/2);
			
				//并算出新的余额数
				balance -= transferAmount;
											
				/*在此设置一个停顿，有利于慢出快进，余额容易减少
				try{
					Thread.sleep(100);
				}catch(InterruptedException e){}
				//*/
			
				//写回帐户
				fromAccount.setBalance(balance);
				
			
				//从另一个帐户中获得余额信息		
				balance=toAccount.getBalance();
				
				//把从前一个帐户中提出的款项加到当前帐户余额中
				balance += transferAmount;
			
				//*在此设置一个停顿，有利于快出慢进，余额容易增大
				try{
					Thread.sleep(100);
				}catch(InterruptedException e){}
				//*/
			
				//并写回帐户
				toAccount.setBalance(balance);
				
			//与synchronized对应的花括号
			}		
				
				//计数，循环结束的条件
				transferCount++;
		}
	}
}


//设计共享资源，此处为银行帐户
class CustomerAccount{
	//余额
	protected double balance;
		
	public CustomerAccount(double initialBalance){
		balance=initialBalance;	
	}
	
	//获取余额数	
	public double getBalance(){
		return balance;
	}
	
	//操作（取出或存入）后更改余额数
	public void setBalance(double newBalance){
		balance=newBalance;
	}
}