public class RegularExpressionMatching{
    public static boolean isMatch(String s, String p){
        return helper(s, p, 0, 0);
    }
    public static boolean helper(String s, String p, int i, int j){
        if(j == p.length())
            return i == s.length();
        if(j == p.length() - 1 || p.charAt(j + 1) != '*'){
            if(i == s.length() || (s.charAt(i) != p.charAt(j) && p.charAt(j) != '.'))
                return false;
            else
            return helper(s, p, i + 1, j + 1);
        }
        while(i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')){
            if(helper(s, p, i, j + 2))
                return true;
            i++;
        }
        return helper(s, p, i, j + 2);
    }
    public static boolean isMatchAlt(String s, String p){
        boolean[][] d = new boolean[p.length() + 1][s.length() + 1];
        d[0][0] = true;
        for(int i = 1;i <= s.length();i++){
            d[0][i] = false;
        }
        for(int i = 2;i <= p.length();i++){
            if(p.charAt(i - 1) == '*' && i - 2 >= 0 && d[i - 2][0])
                d[i][0] = true;
        }
        for(int i = 1;i <= p.length();i++){
            for(int j = 1;j <= s.length();j++){
                char pchar = p.charAt(i - 1);
                char schar = s.charAt(j - 1);
                if(pchar == schar || pchar == '.')
                    d[i][j] = d[i - 1][j - 1];
                else if(pchar == '*'){
                    if(p.charAt(i - 1 - 1) == '.' || p.charAt(i - 1 - 1) == s.charAt(j - 1))
                        d[i][j] = d[i - 1][j - 1] || d[i][j - 1] || d[i - 1][j]; 
                    d[i][j] = d[i][j] || (i - 2 >= 0 && d[i - 2][j]);
                }
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
        System.out.println(isMatch("cc", "**"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("ab", ".*c"));
        System.out.println(isMatch("a", "a."));
        System.out.println(isMatch("aaa", "ab*ac*a"));
        System.out.println(isMatch("aaa", "ab*a*c*a"));
        System.out.println("================");
        System.out.println(isMatchAlt("ab", ".*"));
        System.out.println(isMatchAlt("ab", ".*c"));
        System.out.println(isMatchAlt("a", "a."));
        System.out.println(isMatchAlt("aaa", "ab*ac*a"));
        System.out.println(isMatchAlt("aaa", "ab*a*c*a"));

        System.out.println("..");
        System.out.println(isMatchAlt("a", "*a"));
        System.out.println(isMatchAlt("aab", "c*a*b"));
    }
}
