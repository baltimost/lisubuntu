public class UniquePathsII{
    public static int uniquePathsWithObstacles(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] matrix = new int[m][n]; 
        int i;
        for(i = 0;i < n;i++){
            if(obstacleGrid[0][i] != 1)
                matrix[0][i] = 1;
            else
                break;
        }
        for(i = 0;i < m;i++){
            if(obstacleGrid[i][0] != 1)
                matrix[i][0] = 1;
            else
                break;
        }
        for(i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                if(obstacleGrid[i][j] == 1)
                    matrix[i][j] = 0;
                else
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        for(int[] x: matrix){
            for(int y: x)
                System.out.print(y + " ");
            System.out.println();
        }
        return matrix[m - 1][n - 1];
    }
    public static void main(String[] args){
        int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
        //int[][] grid = {{0,1,0,0,0},{0,0,1,0,0},{0,0,0,0,0}};
        //int[][] grid = {{0}}; 
        System.out.println(uniquePathsWithObstacles(grid));
    }
}
