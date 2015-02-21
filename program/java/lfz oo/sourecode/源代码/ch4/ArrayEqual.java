//: ArrayEqual.java

//package g3ds.joop.ch4;

public class ArrayEqual{ 
	public static void main( String args[] ){ 
		//定义三个int型数组对象
		int[] a=new int[5]; 
		int[] b=new int[5];
		int[] c=new int[5];;
		int i; 
		
		//为a数组的元素赋值
		for( i=0; i<5; i++ ) 
			a[i]=i; 
		
		//利用“＝”把a赋给b
		b=a;
		
		//利用System类的数组复制把a赋给c
		System.arraycopy(a,0,c,0,a.length);
		
		//分别对不同的数组中的元素进行操作
		a[0]=4;
		b[4]=0;
		c[1]=11;
		
		//问题之一：数组对象a和b、c对象之间的关系分别是什么？
		System.out.println("b==a: "+ (b==a));
		System.out.println("c==a: "+ (c==a));
		
		//问题之二：数组a、b、c中个元素的值分别是什么？
		System.out.println("a数组元素的值：");
		for( i=0; i<5; i++) {
			System.out.print("a["+i+"] = "+a[i]+"  "); 
		}
		
		System.out.println("\nb数组元素的值：");
		for( i=0; i<5; i++) {
						System.out.print("b["+i+"] = "+b[i]+"  "); 
		}
		
		System.out.println("\nc数组元素的值：");	
		for( i=0; i<5; i++) {
			System.out.print("c["+i+"] = "+c[i]+"  ");
		}
		System.out.println();
	}
} 