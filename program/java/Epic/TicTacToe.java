public class TicTacToe{
    public static int whoWin(char[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        if(n == 0 || m == 0) return 0;
        int cX = 0;
        int cO = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                char current = matrix[i][j];
                if(current != 'X' && current != 'O') continue;
                int count = current == 'X' ? cX : cO;
                int has3, k;
                for(k = 0,has3 = 0;k < 3 && i + k < n;k++)
                    if(matrix[i + k][j] == current)
                        has3++;
                if(has3 == 3) count++;

                for(k = 0,has3 = 0;k < 3 && i + k < n && j - k >= 0;k++)
                    if(matrix[i + k][j - k] == current)
                        has3++;
                if(has3 == 3) count++;

                for(k = 0,has3 = 0;k < 3 && i + k < n && j + k < m;k++)
                    if(matrix[i + k][j + k] == current)
                        has3++;
                if(has3 == 3) count++;

                for(k = 0,has3 = 0;k < 3 && j + k < m;k++)
                    if(matrix[i][j + k] == current)
                        has3++;
                if(has3 == 3) count++;
                
                cX = current == 'X' ? count : cX;
                cO = current == 'O' ? count : cO;
            }
        }
        System.out.println(cX + "," + cO);
        if(cO - cX > 0) return 1;
        else if(cO - cX < 0) return -1;
        else return 0;
    }
    public static void main(String[] args){
        char[][] matrix = {
            {'O','X','O','X','O'},
            {'O','X','X','O','X'},
            {'O','X','O','O','X'},
            {'X','O','O','O','X'} 
        };
        System.out.println(whoWin(matrix));
    }
}
