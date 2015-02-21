import java.util.*;

public class Solution{
    public static void rotateMatrix(int[][] matrix){
        int n = matrix.length;
        for(int s = 0, e = n;s < n / 2;s++, e--){
            System.out.println("s:"+s+" e:"+e);
            for(int i = s;i < e - 1;i++){
                int tmp = matrix[s][s + i];
                matrix[s][s + i] = matrix[s + i][e - 1];
                matrix[s + i][e - 1] = matrix[e - 1][e - 1 - i];
                matrix[e - 1][e - 1 - i] = matrix[e - 1 - i][s];
                matrix[e - 1 - i][s] = tmp;
            }        
        }
    }
    public static void sortColors(int[] arr){
        for(int l = 0, r = arr.length - 1, i = 0;i < r;){
            if(arr[i] == 0){
                swap(arr, l, i);
                l++;
            }
            else if(arr[i] == 2){
                swap(arr, i, r);
                r--;
            }
            else
                i++;
        }
    }
    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args){
        int[] arr = {1,2,0,2,1,0,0,1,1,2,1};
        sortColors(arr);
        for(int x : arr)
            System.out.print(x + " ");
        System.out.println();
    }
}
