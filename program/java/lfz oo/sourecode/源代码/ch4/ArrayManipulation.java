//: ArrayManipulation.java

//package g3ds.joop.ch4;

//导入包含Arrays类的包
import java.util.*;

public class ArrayManipulation{
	public static void main(String[] args){
		int count=10;
		//创建一个数组
		int[] array=new int[count];
		for(int i=0; i<array.length; i++)
			array[i]=(int)(Math.random()*100);
		
		//利用arraycopy方法复制数组内容
		int[] arrayCopy=new int[count];
		System.arraycopy(array, 0, arrayCopy, 0, array.length);
		
		//利用底层设计的排序法对数组元素进行排序
		System.out.println("从低层编写排序法：");
		bubbleSort(array);
		for(int i=0; i<array.length; i++)
			System.out.print(array[i]+"  ");
		
		//直接调用Arrays类的sort方法
		System.out.println("\n直接调用Arrays类的sort方法：");	
		Arrays.sort(arrayCopy);
		for(int i=0; i<arrayCopy.length; i++)
			System.out.print(arrayCopy[i]+"  ");
		System.out.println();
	}
	
	//从低层编写数组元素排序方法
	static void bubbleSort(int[] array){
		int n=array.length-1;
		for(int i=0; i<n; i++){
			for(int j=0; j<n-i; j++){
				if(array[j]>array[j+1]){
					int temp=array[j+1];
					array[j+1]=array[j];
					array[j]=temp;
				}
			}
		}
	}
}