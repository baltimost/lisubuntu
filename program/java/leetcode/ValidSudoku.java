import java.util.*;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        boolean[] visited = new boolean[9];
        for(int i = 0;i < 9;i++){
            Arrays.fill(visited, false);
            for(int j = 0;j < 9;j++){
                if(!isValidBlock(visited, board[i][j]))
                    return false;
            }
        }
        for(int i = 0;i < 9;i++){
            Arrays.fill(visited, false);
            for(int j = 0;j < 9;j++){
                if(!isValidBlock(visited, board[j][i]))
                    return false;
            }
        }
        for(int i = 0;i < 9;i += 3){
            for(int j = 0;j < 9;j += 3){
                Arrays.fill(visited, false);
                for(int k = 0;k < 3;k++)
                    for(int l = 0;l < 3;l++)
                        if(!isValidBlock(visited, board[i + k][j + l]))
                            return false;
            }
        }
        return true;
    }
    public static boolean isValidBlock(boolean[] visited, char element){
        if(element == '.')
            return true;
        int num = element - '0';
        if(num < 1 || num > 9 || visited[num - 1])
            return false;
        visited[num - 1] = true;
        return true;
    } 
    
    public static void main(String[] args){
        char[][] board = new char[9][9];
        for(int i = 0;i < 9;i++)
            for(int j = 0;j < 9;j++)
                board[i][j] = '.';
        board[0][1] = '1';
        board[0][2] = '2';
        board[0][3] = '3';
        board[0][4] = '4';
        board[0][5] = '5';
        board[0][6] = '6';
        board[0][7] = '7';
        board[0][8] = '8';
        board[1][0] = '9';
        board[2][0] = '7';
        board[3][0] = '6';
        board[4][0] = '5';
        board[5][0] = '4';
        board[6][0] = '3';
        board[7][0] = '2';
        board[8][0] = '1';
        board[3][3] = '2';
        board[5][5] = '3';
        System.out.println(isValidSudoku(board));

        for(char[] x: board){
            for(char y: x)
                System.out.print(y + " ");
            System.out.println();
        }
    }
}

