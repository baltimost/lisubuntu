import java.util.*;

public class SubstringwithConcatenationofAllWords{
    /*TLE
    public static List<Integer> findSubstring(String S, String[] L){
        List<Integer> output = new ArrayList<Integer>();
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        boolean[] d = new boolean[S.length()];
        for(int i = 0;i < L.length;i++)
            dict.put(L[i], dict.get(L[i]) == null ? 1 : dict.get(L[i]) + 1);
        for(int i = 0;i < S.length();i++)
            if(dict.containsKey(S.substring(i, i + L[0].length() > S.length() ? S.length() : i + L[0].length())))
                d[i] = true;
        for(int i = 0;i < S.length();i++){
            int l = i;
            int count = 0;
            words.clear();
            for(int j = i;j < S.length() && d[j];j += L[0].length()){
                count++;
                String word = S.substring(j, j + L[0].length());
                words.put(word, words.get(word) == null ? 1 : words.get(word) + 1);
                if(words.get(word) > dict.get(word)){
                    break;
                }
                if(count == L.length){
                    output.add(l);
                    break;
                }
            }
        }
        return output;
    }
    */
    public static List<Integer> findSubstring(String S, String[] L){
        List<Integer> output = new ArrayList<Integer>();
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        boolean[] d = new boolean[S.length()];
        for(int i = 0;i < L.length;i++)
            dict.put(L[i], dict.get(L[i]) == null ? 1 : dict.get(L[i]) + 1);
        for(int i = 0;i < S.length();i++)
            if(dict.containsKey(S.substring(i, i + L[0].length() > S.length() ? S.length() : i + L[0].length())))
                d[i] = true;
        for(int i = 0;i < L[0].length();i++){
            int l = i;
            int count = 0;
            words.clear();
            for(int j = i;j < S.length();j += L[0].length()){
                //if(!d[j]){
                String word = S.substring(j, j + L[0].length() > S.length() ? S.length() : j + L[0].length());
                if(!dict.containsKey(word)){
                    count = 0;
                    words.clear();
                    l = j + L[0].length(); 
                    continue;
                }
                count++;
                words.put(word, words.get(word) == null ? 1 : words.get(word) + 1);
                if(words.get(word) > dict.get(word)){
                    String extra = S.substring(l, l + L[0].length());
                    while(l < j && !extra.equals(word)){
                        extra = S.substring(l, l + L[0].length());
                        l += L[0].length();
                        if(words.get(extra) > 1)
                            words.put(extra, words.get(extra) - 1);
                        else
                            words.remove(extra);
                        count--;
                    }
                    if(words.get(extra) > 1)
                        words.put(extra, words.get(extra) - 1);
                    else
                        words.remove(extra);
                    count--;
                    l += L[0].length();
                    continue;
                }
                if(count == L.length){
                    output.add(l);
                    count--;
                    String left = S.substring(l, l + L[0].length());
                    if(words.get(left) > 1)
                        words.put(left, words.get(left) - 1);
                    else
                        words.remove(left);
                    l += L[0].length();
                    continue;
                }
            }
        }
        return output;
    }
    public static void main(String[] args){
        String S = "barfoothefoobarman";
        String[] L = {"foo", "bar"};
        /*
        String S = "abababab";
        String[] L = {"a","b","a"};
        */
        /*
        String S = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] L = {"fooo","barr","wing","ding","wing"};
        */
        
        List<Integer> output = findSubstring(S, L);
        for(Integer x: output)
            System.out.print(x + " ");
        System.out.println();
    }
}
