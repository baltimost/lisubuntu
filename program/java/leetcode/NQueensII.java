import java.util.*;

public class NQueensII{
    static int count = 0;
    public static int totalNQueens(int n){
        int[] thQueen = new int[n];
        helper(n, thQueen, 0);
        return count; 
    }
    private static void helper(
            int n,
            int[] thQueen,
            int row){
        if(row == n){
            count++;
            return;
        }
        for(int i = 0;i < n;i++){
            thQueen[row] = i;
            if(isValid(thQueen, row)){
                helper(n, thQueen, row + 1);
            }
        }
    }
    private static boolean isValid(int[] thQueen, int row){
        for(int i = 0;i < row;i++){
            if(thQueen[row] == thQueen[i] || row - thQueen[row] == i - thQueen[i] || row + thQueen[row] == i + thQueen[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println(totalNQueens(2));
        System.out.println(totalNQueens(3));
        System.out.println(totalNQueens(5));
    }
}
