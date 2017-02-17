import java.util.*;

import java.util.*;

public class WordBreakII{
    /*9 Chapter
    public static int count = 0;
	public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        return wordBreakHelper(s,dict,map);
    }

    public static ArrayList<String> wordBreakHelper(String s, Set<String> dict, Map<String, ArrayList<String>> memo){
        
        System.out.println(count++ + " " + s);
        if(memo.containsKey(s)) return memo.get(s);
        ArrayList<String> result = new ArrayList<String>();
        int n = s.length();
        if(n <= 0) return result;
        for(int len = 1; len <= n; ++len){
            String subfix = s.substring(0,len);
            if(dict.contains(subfix)){
                if(len == n){
                    result.add(subfix);
                }else{
                    String prefix = s.substring(len);
                    ArrayList<String> tmp = wordBreakHelper(prefix, dict, memo);
                    for(String item:tmp){
                        item = subfix + " " + item;
                        result.add(item);
                    }
                }
            }
        }
        memo.put(s, result);
        return result;
    }
    /**/
    /*My code*/
    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<ArrayList<String>> d = new ArrayList<ArrayList<String>>();
        ArrayList<String> entry = new ArrayList<String>();
        entry.add("");
        d.add(entry);
        for(int i = 1;i < s.length() + 1;i++){
            entry = new ArrayList<String>();
            for(int j = 0;j < i;j++){
                if(d.get(j).size() > 0){
                    String remain = s.substring(j, i);
                    if(dict.contains(remain)){
                        for(int k = 0;k < d.get(j).size();k++){
                            String sentence = d.get(j).get(k) + " " + remain;
                            entry.add(sentence.trim());
                        }
                    }
                }
            }
            d.add(entry);
        }
        return d.get(s.length());
    }
    public static List<String> wordBreakBetter(String s, Set<String> dict) {
        List<String> output = new ArrayList<String>();
        //List<List<String>> d = new ArrayList<List<String>>();
        List<String>[] d = new List[s.length() + 1];
        d[0] = new ArrayList<String>();
        d[0].add("");
        for(int i = 1;i <= s.length();i++) {
            List<String> entry = new ArrayList<String>();
            for(int j = 0;j < i;j++) {
                if(d[j] != null) {
                    String remain = s.substring(j, i);
                    if(dict.contains(remain)) {
                        for(String str : d[j]) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str + " " + remain);
                            entry.add(sb.toString().trim());
                        }
                    }
                }
            }
            d[i] = entry;
        }
        return d[s.length()];
    }
    /**/
    /*Lexi's code
    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0)
            return new ArrayList<String>();
        HashMap<Integer, ArrayList<String>> cache = new HashMap<Integer, ArrayList<String>>();
        return split(s, dict, 0, cache);
    }
    private static ArrayList<String> split(String s, Set<String> dict, int i, HashMap<Integer, ArrayList<String>> cache) {
        if (i == s.length())
            return null;
        if (cache.containsKey(i))
            return cache.get(i);
        ArrayList<String> result = new ArrayList<String>();
        for (int j = i; j < s.length(); j++) {
            String curr = s.substring(i, j + 1);
            if (dict.contains(curr)) {
                ArrayList<String> rest = split(s, dict, j + 1, cache);
                if (rest == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(curr);
                    result.add(sb.toString());
                } else {
                    for (String tail : rest) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(curr).append(" ").append(tail);
                        result.add(sb.toString());
                    }
                }
            }
        }
        cache.put(i, result);
        return cache.get(i);
    }
   /* */

    public static void main(String[] args){
        HashSet<String> test = new HashSet<String>();
        String tests = "cars";
        test.add("car");
        test.add("ca");
        test.add("rs");
        /*
        String tests = "catsanddog";
        test.add("cat");
        test.add("cats");
        test.add("and");
        test.add("sand");
        test.add("dog");
        *//*
        String tests = "leetcode";
        test.add("leet");
        test.add("le");
        test.add("et");
        test.add("code");
        
        */
        /*
		String tests = "aaaaaaaaaaaaaaaaaaaaaab";
        test.add("a");
        test.add("aa");
        test.add("aaa");
        test.add("aaaa");
		test.add("aaaaa");
		test.add("aaaaaa");
        */
	    
        Long before = System.currentTimeMillis();    
        ArrayList<String> output = wordBreak(tests, test);
        Long after = System.currentTimeMillis();
        System.out.println(after - before);
       /* 
        for(String x: output)
            System.out.println(x);
            */
    }
}

	
	////////////////
	
