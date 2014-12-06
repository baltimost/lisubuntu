public class MagicSquare{
    public static void fillSquare(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        if(n == 0 || m == 0 || n != m || n % 2 == 0)
            return;
        for(int i = 0, j = n / 2, k = 1;k <= n * n;k++){

            matrix[i][j] = k;
            int ni = i - 1 == - 1 ? n - 1: i - 1;
            int nj = (j + 1) % n;
            if(matrix[ni][nj] != 0)
                i = (i + 1) % n; 
            else{
                i = ni;
                j = nj;
            }
        }
    }
    public static void main(String[] args){
        int n = 13;
        int[][] matrix = new int[n][n];
        fillSquare(matrix);
        for(int[] x : matrix){
            for(int y : x){
                int len = String.valueOf(y).length();
                System.out.print(y);
                for(int i = 0;i < 4 - len;i++)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
