import java.util.*;

public class Solution {
    public static void solve(char[][] board) {
        helper(board, 0);
    }
    private static boolean helper(char[][] board, int start) {
        int n = board.length;
        if(start == n * n) {
            return true;
        }
        int row = start / n;
        int col = start % n;
        if(board[row][col] != '.') {
            return helper(board, start + 1);
        }
        for(int i = 1;i <= 9;i++) {
            board[row][col] = (char)(i + '0');
            if(isValid(board, row, col) && helper(board, start + 1)) {
                return true;
            }
        }
        board[row][col] = '.';
        return false;
    }
    private static boolean isValidBlock(char[][] board, int i, int j){
        for(int k = 0;k < board.length;k++)
            if(k != i && board[k][j] == board[i][j])
                return false;
        for(int k = 0;k < board[0].length;k++)
            if(k != j && board[i][k] == board[i][j])
                return false;
        for(int m = i / 3 * 3;m < i / 3 * 3 + 3;m++){
            for(int n = j / 3 * 3;n < j / 3 * 3 + 3;n++)
               if(m != i && n != j && board[m][n] == board[i][j])
                  return false; 
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        for(int i = 0;i < n;i++) {
            if(i != row && board[i][col] == board[row][col]) {
                return false;
            }
            if(i != col && board[row][i] == board[row][col]) {
                return false;
            }
        }
        int r = row / 3 * 3;
        int c = col / 3 * 3;
        for(int i = r;i < r + 3;i++) {
            for(int j = c;j < c + 3;j++) {
                if(i != row && j != col && board[i][j] == board[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] input = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}};
        solve(input);
        for(char[] x : input) {
            for(char y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
