import java.util.*;

public class SurroundedRegions{
    public static void solve(char[][] board){
        int m = board.length;
        int n = board[0].length;
        /*
        for(char[] x: board){
            for(char y: x)
                System.out.print(y + " ");
            System.out.println();
        }
        */
        for(int i = 0;i < n;i++){
            if(board[0][i] == 'O')
                fill(board, 0, i);
            if(board[m - 1][i] == 'O')
                fill(board, m - 1, i);
        }
        for(int i = 0;i < m;i++){
            if(board[i][0] == 'O')
                fill(board, i, 0);
            if(board[i][n - 1] == 'O')
                fill(board, i, n - 1);
        }
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(board[i][j] == 'O')
                    board[i][j] = '*';
                if(board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
        System.out.println();
        for(char[] x: board){
            for(char y: x)
                System.out.print(y + " ");
            System.out.println();
        }
    }
    /* Slower than below by at least 20times
    private static void fill(char[][] board, int i, int j){
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{i, j});
        while(!q.isEmpty()){
            int[] top = q.poll();
            board[top[0]][top[1]] = '#';
            if(top[0] - 1 >= 0 && board[top[0] - 1][top[1]] == 'O')
                q.offer(new int[]{top[0] - 1, top[1]});
            if(top[0] + 1 < board.length && board[top[0] + 1][top[1]] == 'O')
                q.offer(new int[]{top[0] + 1, top[1]});
            if(top[1] - 1 >= 0 && board[top[0]][top[1] - 1] == 'O')
                q.offer(new int[]{top[0], top[1] - 1});
            if(top[1] + 1 < board[0].length && board[top[0]][top[1] + 1] == 'O')
                q.offer(new int[]{top[0], top[1] + 1});
        }
    }
    */
    /**/
    private static void fill(char[][] board, int i, int j){
        Queue<Integer> q = new LinkedList<Integer>();
        int m = board.length;
        int n = board[0].length;
        q.offer(i * n + j);
        board[i][j] = '#';
        while(!q.isEmpty()){
            int top = q.poll();
            int row = top / n;
            int col = top % n; 
            if(row - 1 >= 0 && board[row - 1][col] == 'O'){
                q.offer((row - 1) * n + col);
                board[row - 1][col] = '#';
            }
            if(row + 1 < m && board[row + 1][col] == 'O'){
                q.offer((row + 1) * n + col);
                board[row + 1][col] = '#';
            }
            if(col - 1 >= 0 && board[row][col - 1] == 'O'){
                q.offer(row * n + col - 1);
                board[row][col - 1] = '#';
            }
            if(col + 1 < n && board[row][col + 1] == 'O'){
                q.offer(row * n + col + 1);
                board[row][col + 1] = '#';
            }
        }
    }
    /**/
    public static void main(String[] args){
        /*
        char[][] input = {
            {'*','*','O','O','*','O','*','*','*'},
            {'*','*','O','*','O','O','*','*','O'},
            {'*','*','O','O','O','O','O','*','O'},
            {'O','*','O','O','O','O','*','*','O'},
            {'O','O','*','*','*','*','O','*','O'},
            {'*','*','O','O','*','*','*','O','O'},
            {'*','*','*','O','O','O','*','*','*'},
            {'*','*','*','O','*','*','*','*','*'}};
        solve(input);
        */
        char[][] input = {
            {'*','*','O','O','*','*','*','*','*'},
            {'*','*','*','*','*','*','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','O','*','*','*','*','O','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'O','*','O','O','O','O','*','*','*'},
            {'*','*','O','O','*','*','*','O','*'},
            {'*','*','*','O','O','O','*','*','*'}};
        long before = System.currentTimeMillis();
        solve(input);
        long after = System.currentTimeMillis();
        System.out.println(after - before);
    }
}
