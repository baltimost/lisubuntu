import java.util.*;

public class WordBreak{
    /*Wrong answer, what if "cars", ["car","ca","rs"]?
    public static boolean wordBreak(String s, Set<String> dict) {
        boolean hasWord = false;
        while(!s.equals("")){
            hasWord = false;
            for(Iterator i = dict.iterator();i.hasNext();){
                String word = (String)i.next();
                if(s.contains(word)){
                    s = s.replace(word,"");
                    hasWord = true;
                }
            }
            if(!hasWord)
                return false;
        }
        return true;
    }
     */
    /*Recursive Time Limit Exceeded
    public static boolean wordBreak(String s, Set<String> dict) {
        if(s.equals(""))
            return true;
        for(String word: dict){
            int len = word.length(); 
            if(len > s.length())
                continue;
            if(s.substring(0, len).equals(word))
                if(wordBreak(s.substring(len, s.length()), dict))
                    return true;
        }
        return false;
    }
     */
    /*Dynamic Programming
    */
    public static boolean wordBreak(String s, Set<String> dict) {
        boolean[] d = new boolean[s.length() + 1];
        d[0] = true;
        for(int i = 1;i < s.length() + 1;i++){
            for(int j = 0;j < i;j++)
                if(d[j]){
                    String remain = s.substring(j, i);
                    System.out.println("remain: " + remain);
                    if(dict.contains(remain)){
                        d[i] = true;
                        break;
                    }
                }
        }
        for(boolean x: d)
            System.out.print(x + " ");
        System.out.println();
        return d[s.length()];
    }

    /*Better DP from Creek
    public static boolean wordBreak(String s, Set<String> dict) {
        boolean[] t = new boolean[s.length()+1];
        t[0] = true; //set first to be true, why?
        //Because we need initial state

        for(int i=0; i<s.length(); i++){
            //should continue from match position
            if(!t[i]) 
                continue;

            for(String a: dict){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;

                if(t[end]) continue;

                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }
        }
        for(boolean x: t)
            System.out.print(x + " ");
        System.out.println();

        return t[s.length()];
    }
    */

    public static void main(String[] args){
        HashSet<String> test = new HashSet<String>();
        /*
        String tests = "cars";
        test.add("car");
        test.add("ca");
        test.add("rs");
        */
        String tests = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        test.add("a");
        test.add("aa");
        test.add("aaa");
        test.add("aaaa");
        test.add("aaaaa");
        test.add("aaaaaa");
        test.add("aaaaaaa");
        test.add("aaaaaaaa");
        test.add("b");
        System.out.println(wordBreak(tests,test));
    }
}

