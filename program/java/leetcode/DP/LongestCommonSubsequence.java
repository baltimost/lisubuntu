public class LongestCommonSubsequence {
    public static int longest(int[] X, int[] Y) {
        int M = X.length, N = Y.length;
        int[][] d = new int[M + 1][N + 1];
        for(int i = 1;i <= M;i++) {
            for(int j = 1;j <= N;j++){
                if(X[i - 1] == Y[j - 1]){
                    d[i][j] = d[i - 1][j - 1] + 1;
                }
                else {
                    d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]);
                }
            }
        }
        return d[M][N];
    }

    public static void main(String[] args) {
        /*
        int[] X = {1,2,3,2,4,1,2};
        int[] Y = {2,4,3,1,2,1};
        */
        int[] X = {82,71,66,60,49,49,11,3};
        int[] Y = {3,11,49,49,60,66,71,82};
        System.out.println(longest(X, Y));
    }
}
