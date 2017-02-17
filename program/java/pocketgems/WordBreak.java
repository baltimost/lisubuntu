import java.util.*;

public class WordBreak {
    public static List<String> wordBreakBetter(String s, Set<String> wordDict) {
        List<List<String>> d = new ArrayList<List<String>>();
        d.add(new ArrayList<String>());
        d.get(0).add("");
        for(int i = 1;i <= s.length();i++) {
            List<String> entry = new ArrayList<String>();
            for(int j = i - 1;j >= 0;j--) {
                if((d.get(j).size() > 0) && wordDict.contains(s.substring(j, i))) {
                    for(String str : d.get(j)) {
                        StringBuilder sentence = new StringBuilder();
                        sentence.append(str);
                        sentence.append(" ");
                        sentence.append(s.substring(j,i));
                        entry.add(sentence.toString().trim());
                    }
                }
            }
            d.add(entry);
        }
        return d.get(d.size() - 1);
    }
    
    public static List<String> wordBreak(String s, Set<String> dict) {
        List<String> output = new ArrayList<String>();
        List<String> entry = new ArrayList<String>();
        helper(output, entry, 0, s, dict);
        return output;
    }

    public static void helper(List<String> output, List<String> entry, int start, String s, Set<String> dict) {
        if(start == s.length()) {
            StringBuilder sentence = new StringBuilder();
            for(String str : entry) {
                sentence.append(" ");
                sentence.append(str);
            }
            output.add(sentence.toString().trim());
        }
        for(int i = start + 1;i <= s.length();i++) {
            String word = s.substring(start, i);
            if(dict.contains(word)) {
                entry.add(word);
                helper(output, entry, i, s, dict);
                entry.remove(entry.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String str = "lllllllllllllllcatsanddog";
        //String str = "catsanddog";
        Set<String> s = new HashSet<String>();
        s.add("cat");
        s.add("cats");
        s.add("sand");
        s.add("and");
        s.add("dog");
        s.add("l");
        s.add("ll");
        s.add("lll");
        s.add("catsan");
        s.add("og");

        long start = System.currentTimeMillis();
        //List<String> rst = wordBreak(str, s);
        List<String> rst = wordBreakBetter(str, s);
        long end = System.currentTimeMillis();
        for(String sentence : rst) {
            System.out.println(sentence);
        }
        System.out.println(end - start);
    }
}
