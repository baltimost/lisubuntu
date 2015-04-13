public class ScrambleString{
    public static boolean isScramble(String s1, String s2){
        int n = s1.length();
        boolean[][][] d = new boolean[n][n][n + 1];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++)
                d[i][j][1] = s1.charAt(i) == s2.charAt(j);
        }
        for(int k = 2;k <= n;k++)
            for(int i = 0;i + k < n + 1;i++)
                for(int j = 0;j + k < n + 1;j++)
                    for(int l = 1;l < k;l++)
                        if((d[i][j][l] && d[i + l][j + l][k - l]) 
                            || (d[i][j + k - l][l] && d[i + l][j][k - l])) {
                            d[i][j][k] = true;
                            break;
                        } 
        for(boolean[][] x: d){
            for(boolean[] y: x){
                for(boolean z: y)
                    System.out.print(z ? " O" : " .");
                System.out.println();
            }
            System.out.println("===");
        }
        return d[0][0][n];
    }
    public static void main(String[] args){
        //System.out.println(isScramble("rt","tr"));
        System.out.println(isScramble("abc","bca"));
        //System.out.println(isScramble("eat","tea"));
    }
}
