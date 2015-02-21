//HelloWorldInput.java

//package g3ds.joop.ch2;

public class HelloWorldInput{
	public static void main(String[] args){
		if(args.length==0){
			System.out.println("No Input!");
		}
		else{
			//print方法为不换行打印
			System.out.print("Input:");
			for (int i=0; i<args.length;i++){
				System.out.print( " "+ args[i]);
			}
			//println为换行打印
			System.out.println();
			
			System.out.println("Output:");
			for (int i=0; i<args.length;i++){
				System.out.println(args[i] + " ");
			}
		}
			
		System.exit(0);
	}
}