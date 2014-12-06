public class JumpChess{
    static int  max = 0;
    public static int longestPath(char[][] matrix, int i, int j){
        helper(matrix, i, j, 0); 
        return max;
    }
    private static void helper(char[][] matrix, int i, int j, int len){
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] != ' ')
           return; 
        max = Math.max(max, len);
        if(i - 1 >= 0 && matrix[i - 1][j] == 'X'){
            matrix[i - 1][j] = '*';
            helper(matrix, i - 2, j, len + 2);
            matrix[i - 1][j] = 'X';
        }
        if(i + 1 < matrix.length && matrix[i + 1][j] == 'X'){
            matrix[i + 1][j] = '*';
            helper(matrix, i + 2, j, len + 2);
            matrix[i + 1][j] = 'X';
        }
        if(j - 1 >= 0 && matrix[i][j - 1] == 'X'){
            matrix[i][j - 1] = '*';
            helper(matrix, i, j - 2, len + 2);
            matrix[i][j - 1] = 'X';
        }
        if(j + 1 < matrix[0].length && matrix[i][j + 1] == 'X'){
            matrix[i][j + 1] = '*';
            helper(matrix, i, j + 2, len + 2);
            matrix[i][j + 1] = 'X';
        }
    }
    public static void main(String[] args){
        char[][] chess = {
            {' ',' ',' ','X',' ','X',' '},
            {' ',' ',' ',' ',' ',' ','X'},
            {' ',' ',' ','X',' ',' ',' '},
            {' ','X','X',' ','X',' ','X'},
            {'X',' ',' ',' ',' ','X',' '},
            {' ',' ','X',' ',' ',' ','X'},
            {' ',' ',' ','X',' ','X',' '},
            {' ',' ',' ',' ',' ',' ',' '},
        };
        System.out.println(longestPath(chess, 1, 5));
    }
}
