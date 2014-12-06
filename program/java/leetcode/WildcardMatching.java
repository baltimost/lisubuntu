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
            //d[0] = d[0] && p.charAt(j) == '*';
        }
        return d[s.length()];
    }
    
    public static void main(String[] args){
        System.out.println(isMatch("ab", "?*"));
        System.out.println(isMatch("aac", "*p"));
        System.out.println(isMatch("a", "*a"));
    }
}
