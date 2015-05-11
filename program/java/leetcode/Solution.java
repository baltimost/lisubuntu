import java.util.*;

public class Solution {
    public List<String[]> nQueens(int n) {
        List<String[]> output = new ArrayList<String[]>();
    }
    private void helper(int n, int row, int[] thQueen, List<String[]> output) {
        if(row == n) {
            String[] entry = new String[n];
            for(int i = 0;i < n;i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0;j < n;j++) {
                    sb.append(j == thQueen[i] ? "Q" : ".");
                }
                entry[i] = sb.toString();
            }
            output.add(entry);
            return;
        }
        for(int i = 0;i < n;i++) {
            thQueen[row] = i;
            if(isValid(thQueen, row)) {
                helper(n, row + 1, thQueen, output);
            }
        }
    }
    private boolean isValid(int[] thQueen, int row) {
        for(int i = 0;i < row;i++) {
            if(thQueen[i] == thQueen[row]) {
                return false;
            }
            if(Math.abs((thQueen[i] - thQueen[row]) / (i - row)) == 1) {
                return false;
            } 
        }
        return true;
    }

}
