import java.util.*;

public class NQueens{
    /*
    public static List<String[]> solveNQueens(int n){
        boolean[][] visited = new boolean[n][n];
        List<String[]> output = new ArrayList<String[]>();
        helper(n, 0, visited, output);
        return output;
    }
    private static void helper(
            int n,
            int line,
            boolean[][] visited,
            List<String[]> output){
        if(line == n){
            StringBuilder sb = new StringBuilder();
            String[] entry = new String[n];
            for(int i = 0;i < n;i++){
                sb = new StringBuilder();
                for(int j = 0;j < n;j++)
                    if(visited[i][j])
                        sb.append("Q");
                    else
                        sb.append(".");
                entry[i] = sb.toString();
            }
            output.add(entry);
            return;
        }
        for(int i = line;i < n;i++){
            for(int j = 0;j < n;j++){
                if(isValid(i, j, visited)){
                    visited[i][j] = true;
                    helper(n, line + 1, visited, output);
                    visited[i][j] = false;
                }
            }
        }
    }
    private static boolean isValid(int i, int j, boolean[][] visited){
        for(int k = 0;k < visited.length;k++)
            if(visited[i][k])
                return false;
        for(int k = 0;k < visited.length;k++)
            if(visited[k][j])
                return false;
        for(int k = 0;k < visited.length;k++)
            for(int l = 0;l < visited.length;l++)
                if(k - l == i - j || k + l == i + j){
                    if(visited[k][l]){
                        return false;
                    }
                } 
        return true;
    }
    */
    public static List<String[]> solveNQueens(int n){
        List<String[]> output = new ArrayList<String[]>();
        int[] thQueen = new int[n];
        helper(n, thQueen, 0, output);
        return output; 
    }
    private static void helper(
            int n,
            int[] thQueen,
            int row,
            List<String[]> output){
        if(row == n){
            StringBuilder sb = new StringBuilder();
            String[] entry = new String[n];
            for(int i = 0;i < n;i++){
                sb = new StringBuilder();
                for(int j = 0;j < n;j++)
                    sb.append(j == thQueen[i] ? "Q" : ".");
                entry[i] = sb.toString();
            }
            output.add(entry);
            return;
        }
        for(int i = 0;i < n;i++){
            thQueen[row] = i;
            if(isValid(thQueen, row)){
                helper(n, thQueen, row + 1, output);
            }
        }
    }
    private static boolean isValid(int[] thQueen, int row){
        for(int i = 0;i < row;i++){
            if(thQueen[row] == thQueen[i] || Math.abs(thQueen[i] - thQueen[row]) == Math.abs(i - row))
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        List<String[]> output = solveNQueens(8);
        System.out.println("=====");
        int count = 0;
        for(String[] x: output){
            for(int i = 0;i < x.length;i++)
                System.out.println(x[i]);
            System.out.println(count++);
        }
        System.out.println("=====");
    }
}
