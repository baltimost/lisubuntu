// MagicSquare.java

//package g3ds.joop.ch3;

import java.io.*;

public class MagicSquare{
	public static void main(String[] args) throws IOException{
		int n, i, j, k;
		int tempi, tempj;
		int[][] a;
	
		System.out.print("Please input an odd integer:");
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String str=stdin.readLine();
		n=Integer.parseInt(str);
		if(n<=0 || n%2==0){
			System.out.print("Invalid number!\n");
			return;
		}	
		
		a=new int[n][n];
	
		i=0; j=n/2;
		a[0][n/2]=1;
		for(k=2; k<=n*n; ++k){
			tempi=i--;
			tempj=j--;

			if(i<0) i=n-1;
			if(j<0) j=n-1;
			if(a[i][j]!=0){
				i=tempi+1;
				j=tempj;
				if(i>=n) i=0;
			}

		a[i][j]=k;

		}
		
		
		System.out.println("The magic square is");
		for(i=0; i<n; ++i){
			for(j=0; j<n; ++j){
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	}
}