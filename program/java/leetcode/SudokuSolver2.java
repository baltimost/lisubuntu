public class SudokuSolver{
    public static void solveSudoku(char[][] board){
        helper(board, 0);
    }
    private static boolean helper(char[][] board, int start){
        /*
        if(start == board.length * board[0].length)
            return true;
            */

        for(int i = start;i < board.length * board[0].length;i++){
            int row = i / board[0].length;
            int col = i % board[0].length;
            if(board[row][col] == '.'){
                for(int j = 1; j <= 9;j++){
                    board[row][col] = (char)(j + '0');
                    if(isValidBlock(board, row, col))
                        if(helper(board, i + 1))
                            return true;
                }
                board[row][col] = '.';
                return false;
            }
        }
        return true;
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
    public static void main(String[] args){
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
        solveSudoku(input);

        for(char[] x: input){
            for(char y: x)
                System.out.print(y + " ");
            System.out.println();
        }
    }
}
