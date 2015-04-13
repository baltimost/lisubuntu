public class MinimumPathSum{
    public static int minPathSum(int[][] grid){
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid[0].length;
        int n = grid.length;
        int[] d = new int[m];
        d[0] = grid[0][0];
        for(int i = 1;i < m;i++) {
            //d[i] += grid[0][i - 1];
            d[i] = d[i - 1] + grid[0][i];
        }
        for(int i = 1;i < n;i++) {
            d[0] += grid[i][0];
            for(int j = 1;j < m;j++) {
                d[j] = Math.min(d[j - 1], d[j]) + grid[i][j];
            }
        }
        return d[m - 1];
    }
   
    public static void main(String[] args) {
        int[][] grid = {
            {2,20,1},
            {17,7,11},
            {49,10,4}
        };
        System.out.println(minPathSum(grid));
    }
}

