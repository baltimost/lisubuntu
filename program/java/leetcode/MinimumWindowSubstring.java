import java.util.*;

public class MinimumWindowSubstring{
    public static String minWindow(String S, String T){
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        HashMap<Character, Integer> character = new HashMap<Character, Integer>();
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
                character.put(cur, character.get(cur) == null ? 1 : character.get(cur) + 1); 
                if(character.get(cur) <= dict.get(cur))
                    count++;
                while(count == T.length()){
                    if(output.equals("") || i - leftbound + 1 < output.length()){
                        System.out.println("leftbound="+leftbound+" rightbound="+(i+1));
                        output = S.substring(leftbound, i + 1);
                    }
                    char left = S.charAt(leftbound);
                    if(character.get(left) > dict.get(left))
                        character.put(left, character.get(left) - 1);
                    else{ 
                        if(character.get(left) > 1)
                            character.put(left, character.get(left) - 1);
                        else
                            character.remove(left);
                        count--;
                    }
                    leftbound++;
                    while(leftbound < S.length() && !dict.containsKey(S.charAt(leftbound))) 
                        leftbound++;
                }
            }
            else if(character.isEmpty())
                leftbound++;

        }
        return output;
    }
    public static void main(String[] args){
        String S = "aabaabaaab";
        String T = "bb";
        /*
        String S = "ADOBECODEBANC";
        String T = "ABC";
        */
        System.out.println(minWindow(S, T));
    }
}
