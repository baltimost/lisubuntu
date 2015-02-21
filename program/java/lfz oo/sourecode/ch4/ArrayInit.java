//: ArrayInit.java

//package g3ds.joop.ch4;

public class ArrayInit{
	public static void main(String[] args){
		//empty数组举例
		int[] i=new int[0];
		System.out.println("empty数组i的大小："+i.length);
		
		//数组引用null的差别举例
		i=null;
		try{
			System.out.println("数组i引用null访问数组的大小："+i.length);
		}catch(Exception e){
			System.out.println("数组i引用null访问数组的大小将引发异常："+e.toString());
		}
		
		//杨辉三角：声明时直接初始化
		int[][] yanghuiTriangle={
				{1},
				{1,1},
				{1,2,1},
				{1,3,3,1},
				{1,4,6,4,1},
			};
		//empty数组情况
		yanghuiTriangle=createYanghuiTriangle(0);
		printYanghuiTriangle(yanghuiTriangle);
		//一般情况
		yanghuiTriangle=createYanghuiTriangle(6);
		printYanghuiTriangle(yanghuiTriangle);
		
		//创建匿名数组作为实参
		printYanghuiTriangle(new int[][]{{1},{1,1},{1,2,1},{1,3,3,1}});
	}
	
	//本例为了方便于在main方法中调用，把以下方法声明为static
	static int[][] createYanghuiTriangle(int row){
		//利用new运算符分别为多维数组分配空间
		//如果row=0，则创建一个empty数组
		int[][] result=new int[row][];
		for(int i=0; i<result.length; i++){
			int column=i+1;
			result[i]=new int[column];
			
			//杨辉三角每行首尾元素赋值
			result[i][0]=1;
			result[i][i]=1;
		}
		
		//杨辉三角其它元素赋值
		for(int i=1;i<result.length; i++){
			for(int j=1;j<i;j++){
				result[i][j]=result[i-1][j-1]+result[i-1][j];
			}
		}
		
		return result;
	}
	
	static void printYanghuiTriangle(int[][] yanghuiTriangle){
		//判断是否为empty数组
		if(yanghuiTriangle.length==0){
			//处理empty数组
			System.out.println("输入行数为0！");
		}
		else{
			//打印杨辉三角内容
			for(int i=0; i<yanghuiTriangle.length; i++){
				for(int j=0; j<yanghuiTriangle[i].length; j++){
					System.out.print(yanghuiTriangle[i][j]+ "\t");
				}
				System.out.println();
			}
		}
	}
}