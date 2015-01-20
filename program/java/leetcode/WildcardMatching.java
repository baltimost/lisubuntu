public class WildcardMatching{
    /*Recursive TLE
    public static boolean isMatch(String s, String p){
        return helper(s, p, 0, 0);
    }
    public static boolean helper(String s, String p, int i, int j){
        if(j == p.length())
            return i == s.length();
        if(p.charAt(j) != '*'){
            if(i == s.length() || (s.charAt(i) != p.charAt(j) && p.charAt(j) != '?'))
                return false;
            return helper(s, p, i + 1, j + 1);
        }
        while(i < s.length()){
            if(helper(s, p, i, j + 1))
                return true;
            i++;
        }
        return helper(s, p, i, j + 1);
    }
    */
    public static boolean isMatch(String s, String p){
        boolean[] d = new boolean[s.length() + 1];
        d[0] = true;
        for(int j = 0;j < p.length();j++){
            if(p.charAt(j) != '*'){
                for(int i = s.length() - 1;i >= 0;i--)
                    d[i + 1] = d[i] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?');
            }
            else{
                int i = 0;
                for(;i < d.length && !d[i];i++);
                for(;i < d.length;i++) d[i] = true;
            }
            d[0] = d[0] && p.charAt(j) == '*';
        }
        return d[s.length()];
    }
    public static boolean isMatchAlt(String s, String p){
        boolean[][] d = new boolean[p.length() + 1][s.length() + 1];
        d[0][0] = true;
        for(int i = 1;i <= s.length();i++)
            d[0][i] = false;
        for(int i = 1;i <= p.length();i++)
            d[i][0] = p.charAt(i - 1) == '*' && d[i - 1][0];

        for(int i = 1;i <= p.length();i++){
            for(int j = 1;j <= s.length();j++){
                char pchar = p.charAt(i - 1);
                char schar = s.charAt(j - 1);
                if(pchar == schar || pchar == '?')
                    d[i][j] = d[i - 1][j - 1];
                else if(pchar == '*'){
                    //d[i][j] = d[i - 1][j - 1] || d[i - 1][j] || (d[i][j - 1] && schar == s.charAt(j - 1 - 1));
                    //'cause the content of the sequence not necessarily to be the same, I considered a more complicated situtation
                    d[i][j] = d[i - 1][j - 1] || d[i - 1][j] || d[i][j - 1]; 
                }
                else
                    d[i][j] = false;
            }
        }

        System.out.print("    ");
        for(int i = 0;i < s.length();i++)
            System.out.print(s.charAt(i) + " ");
        System.out.println();
        int i = -1;
        for(boolean[] x : d){
            if(i == -1){
                System.out.print("  ");
                i++;
            }
            else
                System.out.print(p.charAt(i++) + " ");
            for(boolean y : x)
                System.out.print(y ? "T " : "F ");
            System.out.println();
        }
           
        return d[p.length()][s.length()];
    }
    
    public static void main(String[] args){
        /*
        System.out.println(isMatch("ab", "?*"));
        System.out.println(isMatch("aac", "*p"));
        System.out.println(isMatch("a", "*a"));
        System.out.println(isMatch("caab", "c*?b"));
        System.out.println(isMatch("ab", "ab*"));
        System.out.println(isMatch("ab", "ab?"));
        System.out.println(isMatch("caab", "c*a*b"));
        */
        /*
        System.out.println("++++++");
        System.out.println(isMatchAlt("ab", "?*"));
        System.out.println(isMatchAlt("aac", "*p"));
        System.out.println(isMatchAlt("a", "*a"));
        System.out.println(isMatchAlt("caab", "c*?b*"));
        System.out.println(isMatchAlt("ab", "ab*"));
        System.out.println(isMatchAlt("ab", "ab?"));
        System.out.println(isMatchAlt("caab", "c*a*b"));
        */

        System.out.println(isMatchAlt("abefcdgiescdfimde", "ab*cd?i*de"));
    }
}
