import java.util.*;

public class MinimumWindowSubstring{
    public static String minWindow(String S, String T){
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int leftbound = 0;
        int count = 0;
        String output = "";
        for(int i = 0;i < T.length();i++){
            char cur = T.charAt(i);
            dict.put(cur, dict.get(cur) == null ? 1 : dict.get(cur) + 1); 
        }
        for(int i = 0;i < S.length();i++){
            char cur = S.charAt(i);
            if(dict.containsKey(cur)){
                hm.put(cur, hm.get(cur) == null ? 1 : hm.get(cur) + 1); 
                if(hm.get(cur) <= dict.get(cur))
                    count++;
                while(count == T.length()){
                    if(output.equals("") || i - leftbound + 1 < output.length()){
                        System.out.println("leftbound="+leftbound+" rightbound="+(i+1));
                        output = S.substring(leftbound, i + 1);
                    }
                    char left = S.charAt(leftbound);
                    if(hm.get(left) > dict.get(left))
                        hm.put(left, hm.get(left) - 1);
                    else{ 
                        if(hm.get(left) > 1)
                            hm.put(left, hm.get(left) - 1);
                        else
                            hm.remove(left);
                        count--;
                    }
                    leftbound++;
                    while(leftbound < S.length() && !dict.containsKey(S.charAt(leftbound))) 
                        leftbound++;
                }
            }
            else if(hm.isEmpty())
                leftbound++;

        }
        return output;
    }
    public static String minWindowAlt(String S, String T){
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int i, j; 
        int count = 0;
        String output = "";
        for(i = 0;i < T.length();i++){
            char cur = T.charAt(i);
            dict.put(cur, dict.get(cur) == null ? 1 : dict.get(cur) + 1); 
        }
        for(i = 0, j = 0;j < S.length();j++){
            char cur = S.charAt(j);
            if(dict.containsKey(cur)){
                hm.put(cur, hm.get(cur) == null ? 1 : hm.get(cur) + 1); 
                if(hm.get(cur) <= dict.get(cur))
                    count++;
                while(count == T.length()){
                    if(output.equals("") || j - i + 1 < output.length())
                        output = S.substring(i, j + 1);
                    char left = S.charAt(i);
                    hm.put(left, hm.get(left) - 1);
                    if(hm.get(left) < dict.get(left))
                        count--;
                    i++;
                    while(i < S.length() && !dict.containsKey(S.charAt(i))) 
                        i++;
                }
            }
            else if(hm.isEmpty())
                i++;
        }
        return output;
    }
    public static void main(String[] args){
        String S = "aabaabaaab";
        String T = "bb";
        //String S = "ADOBECODEBANC";
        //String T = "ABC";
        System.out.println(minWindow(S, T));
        System.out.println(minWindowAlt(S, T));
    }
}
