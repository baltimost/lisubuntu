//: ArraycopyExample.java

//package g3ds.joop.ch4;

public class ArraycopyExample{
	public static void main(String[] args){
		//创建一个int型数组
		int[] i1={1, 2, 3};
		
		//把int型数值从i1复制到i2的部分元素中：i1[0]->i2[1]
		int[] i2=new int[3];
		System.arraycopy(i1, 0, i2, 1, 2);
				
		//由于基本类型的值不能共享，其结果是i1和i2的元素将互不影响
		i1[0]=2;
		System.out.println("对于基本类型，改变复制源数组的元素并不影响目标数组元素\n"+
				"源数组与目标数组相关: "+ (i1[0]==i2[1]));
		
		//创建一个对象数组
		StringBuffer[] str1=new StringBuffer[3];
		str1[0]=new StringBuffer("a");
		str1[1]=new StringBuffer("b");
		str1[2]=new StringBuffer("c");
		
		//把引用类型的值从str1复制到str2的部分元素中：str1[0]->str2[1]
		StringBuffer[] str2=new StringBuffer[3];
		System.arraycopy(str1, 0, str2, 1, 2);
		
		//由于元素中存储的值是对相同StringBuffer对象的引，
		//因此源数组和目标数组元素依然相关
		str1[0]=str1[0].append("a");
		System.out.println("对于引用类型，数组元素中存储的值代表同一个对象的引用\n"+
				"源数组与目标数组相关: "+ (str1[0]==str2[1]));
		
		//创建二维数组
		int[][] array=new int[3][];
		array[0]=new int[]{5, 6};
		array[1]=new int[]{2, 3};
		array[2]=new int[]{7, 8};
		
		//多维数组执行arraycopy方法结果类似
		int[][] arrayCopy=new int[3][2];
		System.arraycopy(array, 0, arrayCopy, 0, 1);
		array[0][0]=0;
		System.out.println("对于多维数组，源数组与目标数组相关: "+ (array[0]==arrayCopy[0]));
		
		//clone方法只能实现单层复制
		int[][] arrayClone=(int[][])array.clone();		
		System.out.println("clone方法只能实现单层复制\n"+
				"array==arrayClone: "+	(array==arrayClone));
		System.out.println("array[0]==arrayClone[0]: "+
				(array[0]==arrayClone[0]));
		
		//要自己实现深层复制
		for(int i=0; i<array.length; i++){
			arrayClone[i]=(int[])array[i].clone();
		}
		System.out.println("自己实现深层复制\n"+
				"array==arrayClone: "+(array==arrayClone));
		System.out.println("array[0]==arrayClone[0]: "+
				(array[0]==arrayClone[0]));	
	}
}