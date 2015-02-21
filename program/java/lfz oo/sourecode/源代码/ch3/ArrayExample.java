//: ArrayExample.java

//package g3ds.joop.ch3;

public class ArrayExample{
	public static void main(String[] args){
		//声明一个二维数组，并直接进行初始化
		int[][] m1={{0, 1, 2},{3, 4},{5, 6, 7, 8, 9}};
		System.out.println("数组对象的超类："+m1.getClass().getSuperclass());
		System.out.println("二维数组m1的元素个数："+m1.length);
		System.out.println("二维数组m1中元素（一维数组）m1[2]的元素个数："+m1[2].length);
		
		//复制二维数组
		int[][] m2=(int[][])m1.clone();
		System.out.println("二维数组m2对m1进行复制，只能实现单层复制");
		System.out.println("\t进行对象复制以后，m1和m2是否为同一对象： "+ (m1==m2));
		System.out.println("\t进行对象复制以后，m1[0]和m2[0]是否为同一对象： "+ (m1[0]==m2[0]));
	}
}