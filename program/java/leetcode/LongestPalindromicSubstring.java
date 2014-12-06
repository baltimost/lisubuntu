public class LongestPalindromicSubstring{
    public static String longestPalindrome(String s){
        int l = 0, r = -1; 
        boolean[][] dict = new boolean[s.length()][s.length()];
        for(int i = s.length() - 1;i >= 0;i--){
            for(int j = i;j < s.length();j++){
                if(s.charAt(i) == s.charAt(j) && (j - i < 2 || dict[i + 1][j - 1])){
                    dict[i][j] = true;
                    if(j - i > r - l){
                        l = i;
                        r = j;
                    }
                }
            }
        }
        return s.substring(l, r + 1);
    }
    public static void main(String[] args){
        System.out.println(longestPalindrome("cabababab"));
    }
}
