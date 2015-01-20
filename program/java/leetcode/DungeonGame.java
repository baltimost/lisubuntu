public class DungeonGame{
    static int max = Integer.MIN_VALUE;
    public static int calculateMinimumHP(int[][] dungeon){
        helper(dungeon, 0, 0, 0, Integer.MAX_VALUE);
        return max >= 0 ?  1 : Math.abs(max) + 1; 
    }
    private static void helper(int[][] dungeon, int i, int j, int sum, int min){
        if(i == dungeon.length - 1 && j == dungeon[0].length - 1){
            sum += dungeon[i][j];
            min = Math.min(min, sum);
            max = Math.max(max, min);
            return;
        }
        if(i == dungeon.length || j == dungeon[0].length)
            return;
        sum += dungeon[i][j];
        min = Math.min(min, sum); 
        helper(dungeon, i + 1, j, sum, min);
        helper(dungeon, i, j + 1, sum, min);
    }
    public static int calculateMinimumHPAlt(int[][] dungeon){
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return -1;
        int n = dungeon.length;
        int m = dungeon[0].length;
        if(n == 1 && m == 1) return dungeon[0][0] >= 0 ? 1 : -dungeon[0][0] + 1;
        Pair[][] d = new Pair[n][m];
        d[0][0] = new Pair(dungeon[0][0], dungeon[0][0]);
        for(int i = 1;i < n;i++){
            int sum = dungeon[i][0] + d[i - 1][0].sum;
            d[i][0] = new Pair(Math.min(d[i - 1][0].min, sum), sum);
        }
        for(int i = 1;i < m;i++){
            int sum = dungeon[0][i] + d[0][i - 1].sum;
            d[0][i] = new Pair(Math.min(d[0][i - 1].min, sum), sum);
        }
        for(int i = 1;i < n;i++){
            for(int j = 1;j < m;j++){
                Pair path;
                int minup = Math.min(d[i - 1][j].min, d[i - 1][j].sum + dungeon[i][j]);
                int minleft = Math.min(d[i][j - 1].min, d[i][j - 1].sum + dungeon[i][j]);
                if(minup > minleft)
                    path = d[i - 1][j];
                else if(minup < minleft)
                    path = d[i][j - 1];
                else
                    path = d[i - 1][j].sum > d[i][j - 1].sum ? d[i - 1][j] : d[i][j - 1];

                int sum = dungeon[i][j] + path.sum;
                d[i][j] = new Pair(Math.min(path.min, sum), sum);
            }
        }

        for(Pair[] x : d){
            for(Pair y : x)
                System.out.print(y.min + "," + y.sum + "  ");
            System.out.println();
        }
        /*
        Pair path = null;
        if(n - 2 < 0) path = d[n - 1][m - 2];
        if(m - 2 < 0) path = d[n - 2][m - 1];
        path = d[n - 2][m - 1].min > d[n - 1][m - 2].min ? d[n - 2][m - 1] : d[n - 1][m - 2];
        int sum = dungeon[n - 1][m - 1] + path.sum;
        d[n - 1][m - 1] = new Pair(Math.min(path.min, sum), sum);
        */
        return d[n - 1][m - 1].min;
    }
    public static int calculateMinimumHPLst(int[][] dungeon){
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] d = new int[n][m];
        int diff = 1 - dungeon[n - 1][m - 1];
        d[n - 1][m - 1] = diff <= 0 ? 1 : diff; 
        for(int i = n - 2;i >= 0;i--){
            diff = d[i + 1][m - 1] - dungeon[i][m - 1];
            d[i][m - 1] = diff <= 0 ? 1 : diff; 
        } 
        for(int i = m - 2;i >= 0;i--){
            diff = d[n - 1][i + 1] - dungeon[n - 1][i];
            d[n - 1][i] = diff <= 0 ? 1 : diff; 
        } 
        for(int i = n - 2;i >= 0;i--){
            for(int j = m - 2;j >= 0;j--){
                if(d[i + 1][j] < d[i][j + 1])
                    diff = d[i + 1][j] - dungeon[i][j]; 
                else
                    diff = d[i][j + 1] - dungeon[i][j]; 
                d[i][j] = diff <= 0 ? 1 : diff;
            }
        }
        for(int[] x : d){
            for(int y : x)
                System.out.print(y + " ");
            System.out.println();
        }
        return d[0][0];
    }
    private static class Pair{
        int min, sum;
        public Pair(int min, int sum){
            this.min = min;
            this.sum = sum;
        }
    }
    public static void main(String[] args){
        /*
        */
        int[][] dungeon = {
            {-2, -3, 3},
            {-5, -10, 1},
            {10, 30, -5}
        };
        /*
        int[][] dungeon = {
            {1, -3, 3},
            {0, -2, 0},
            {-3, -3, -3}
        };
        */
        System.out.println(calculateMinimumHP(dungeon));
        //System.out.println(calculateMinimumHPAlt(dungeon));
        System.out.println(calculateMinimumHPLst(dungeon));
    }
}

