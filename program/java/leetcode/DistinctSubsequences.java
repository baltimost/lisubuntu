public class DistinctSubsequences{
    /*DFS TLE
    static int count = 0;
    public static int numDistinct(String S, String T){
        StringBuilder sb = new StringBuilder();
        helper(sb, S, T, 0);
        return count;
    }
    private static void helper(
            StringBuilder sb,
            String S, 
            String T,
            int start){
        if(sb.length() == T.length()){
            System.out.println(sb.toString());
            if(sb.toString().equals(T))
                count++;
            return;
        }
        for(int i = start;i < S.length();i++){
            if(T.charAt(sb.length()) != S.charAt(i))
                continue;
            sb.append(S.charAt(i));
            helper(sb, S, T, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    */

    public static int numDistinct(String S, String T){
        int[][] d = new int[S.length() + 1][T.length() + 1];
        for(int i = 0;i < d.length;i++)
            d[i][0] = 1;
        for(int i = 1;i < d.length;i++){
            for(int j = 1;j < d[0].length;j++){
                d[i][j] += S.charAt(i - 1) == T.charAt(j - 1) ? d[i - 1][j] + d[i - 1][j - 1] : d[i - 1][j]; 
            }
        }
        return d[S.length()][T.length()];
    }
    public static int numDistinctAlt(String S, String T){
        if(T.length() == 0) return 1;
        if(S.length() == 0) return 0;
        int[][] d = new int[S.length()][T.length()];
        d[0][0] = S.charAt(0) == T.charAt(0) ? 1 : 0;
        for(int i = 1;i < d.length;i++)
            d[i][0] = S.charAt(i) == T.charAt(0) ? d[i - 1][0] + 1 : d[i - 1][0];
        for(int i = 1;i < d.length;i++){
            for(int j = 1;j < d[0].length;j++)
                d[i][j] = S.charAt(i) == T.charAt(j) ? d[i - 1][j - 1] + d[i - 1][j] : d[i - 1][j];
        }
        return d[S.length() - 1][T.length() - 1];
    }
    public static void main(String[] args){
        System.out.println(numDistinct("", "rabbit"));
        System.out.println(numDistinct("rrabbbbit", ""));
        System.out.println(numDistinct("rrabbbbit", "rabbit"));
        System.out.println(numDistinct("", ""));

        System.out.println("------");

        System.out.println(numDistinctAlt("", "rabbit"));
        System.out.println(numDistinctAlt("rrabbbbit", ""));
        System.out.println(numDistinctAlt("rrabbbbit", "rabbit"));
        System.out.println(numDistinctAlt("", ""));
    }
}
