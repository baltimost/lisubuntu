import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters{
    public static int lengthOfLongestSubstring(String s){
        HashSet<Character> hs = new HashSet<Character>();
        int max = 0;
        int leftbound = 0;
        for(int i = 0;i < s.length();i++){
            if(hs.contains(s.charAt(i))){
                while(leftbound < i && s.charAt(leftbound) != s.charAt(i)){
                    hs.remove(s.charAt(leftbound));
                    leftbound++;
                }
                leftbound++;
            } else{
                hs.add(s.charAt(i));
                max = Math.max(max, i - leftbound + 1);
            }
        }
        return max;
    }
    public static void main(String[] args){
        String input = "abhdaefghik";
        System.out.println(lengthOfLongestSubstring(input));
    }
}
