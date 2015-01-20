public class InterleavingString{
    /*Wrong Answer?
    public boolean isInterleave(String s1, String s2, String s3){
        for(int i = 0, j = 0, k = 0,tmp = -1;k < s3.length();){
            if(tmp == k)
                return false;
            tmp = k;
            while(i < s1.length() && (s3.charAt(k) == s1.charAt(i))){
                    i++;
                    k++;
            }
            while(j < s2.length() && (s3.charAt(k) == s2.charAt(j))){
                    j++;
                    k++;
            }
        }
        return true;
    }
    */
    /*DFS TLE*
    public static boolean isInterleave(String s1, String s2, String s3){
        if(s1.length() + s2.length() != s3.length()) return false;
        return helper(s1, 0, s2, 0, s3, 0);
    }
    private  static boolean helper(String s1, int start1, String s2, int start2, String s3, int start3){
        if(start3 == s3.length())
            return true;
        
        if(start1 < s1.length() && s3.charAt(start3) == s1.charAt(start1)){
            boolean rst1 = helper(s1, start1 + 1, s2, start2, s3, start3 + 1);
            if(rst1)
                return true;
        }
        if(start2 < s2.length() && s3.charAt(start3) == s2.charAt(start2)){
            boolean rst2 = helper(s1, start1, s2, start2 + 1, s3, start3 + 1);
            if(rst2)
                return true;
        }
        return false;
    }
    **/
    /*DP*/
    public static boolean isInterleave(String s1, String s2, String s3){
        if(s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length())
            return false; 
        boolean[][] d = new boolean[s1.length() + 1][s2.length() + 1];
        d[0][0] = true; 
        for(int i = 1;i < d[0].length;i++)
            d[0][i] = s2.charAt(i - 1) == s3.charAt(i - 1) && d[0][i - 1];
        for(int i = 1;i < d.length;i++)
            d[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) && d[i - 1][0];
        for(int i = 1;i < d.length;i++){
            for(int j = 1;j < d[0].length;j++){
                d[i][j] = (d[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1))) ||
                          (d[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1)));
            }
        }
        /*
        for(int i = 0;i < d.length;i++){
            System.out.print("||");
            for(int j = 0;j < d[0].length;j++)
               if(!d[i][j])
                   System.out.print("0");
               else
                   System.out.print("1");
            System.out.println();
        }
        */
        return d[s1.length()][s2.length()];
    }
    /**/
    public static void main(String[] args){
        /**
        String s1 = "aabcc", s2 = "dbbca"; 
        String s3 = "aadbbcbcac";
       * */

        /**/
		String s1 ="bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa"; 
        String s2 ="babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
        String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
        /**/
        
        long start = System.currentTimeMillis();
        System.out.println(isInterleave(s1,s2,s3));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
