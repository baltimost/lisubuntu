public class UniquePaths{
    public static int uniquePaths(int m, int n){
        int[][] matrix = new int[m][n];
        for(int i = 0;i < m;i++)
            matrix[i][0] = 1;
        for(int i = 0;i < n;i++)
            matrix[0][i] = 1;
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++)
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
        }
        return matrix[m - 1][n - 1];
    }
    public static int uniquePathsAlt(int m, int n){
        return (int)(getFactorial(m + n - 2) / (getFactorial(n - 1) * getFactorial(m - 1)));
    }
    private static double getFactorial(int n){
        double output = 1;
        while(n > 0)
            output *= n--;
        return output;
    }
    public static void main(String[] args){
        System.out.println(uniquePaths(10,10));
        System.out.println(uniquePathsAlt(10,10));
    }
}
