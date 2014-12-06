import java.util.*;

public class PalindromePartitioningII{
    /*DFS TLE
public static int minCut(String s){ 
        if(s == null)
            return 0;
        List<List<String>> output = new ArrayList<List<String>>();
        List<String> combination = new ArrayList<String>();
        helper(output, 0, combination, s);
        int min = Integer.MAX_VALUE;
        for(List<String> x: output)
            min = Math.min(x.size(), min);
        return min - 1;
    }
    private static void helper(List<List<String>> output, int level, List<String> combination, String s){
        if(s.equals("")){
            List<String> entry = new ArrayList<String>();
            for(int i = 0;i < combination.size();i++)
                entry.add(combination.get(i));
            output.add(entry);
            return;
        }
        String left, right;
        for(int i = 1;i <= s.length();i++){
            left = s.substring(0,i);
            if(isPalindrome(left)){
                if(level >= combination.size())
                    combination.add(left);
                else
                    combination.set(level, left);
                right = s.substring(i);
                helper(output, level + 1, combination, right);
                for(int j = level + 1;j < combination.size();j++)
                    combination.remove(j);
            } 
        }
    } 
    /**/
    /*BFS TLE
    public static int minCut(String s){ 
        if(s == null)
            return 0;
        Queue<List<String>> queue = new LinkedList<List<String>>();
        List<String> entry = new ArrayList<String>();
        entry.add(s);
        queue.offer(entry);
        while(!entry.isEmpty()){
            entry = queue.poll();
            String laststring = entry.get(entry.size() - 1);
            if(isPalindrome(laststring))
                return entry.size() - 1;
            else{
                for(int i = 1;i <= laststring.length();i++){
                    String left = laststring.substring(0,i);
                    if(isPalindrome(left)){
                        String right = laststring.substring(i);
                        List<String> newentry = new ArrayList<String>(entry);
                        newentry.remove(entry.size() - 1);
                        newentry.add(left);
                        newentry.add(right);
                        queue.offer(newentry);
                    }
                }
            }
        }
        return 0;
    }
     /**/
    /*DFS simplified
    static int min = Integer.MAX_VALUE;
    public static int minCut(String s){ 
        helper(0, s, 0);
        return min - 1;
    }
    private static void helper(int start, String s, int count){
        if(s.equals("")){
            min = Math.min(min, count);
        }
        String left, right;
        for(int i = 1;i <= s.length();i++){
            left = s.substring(0, i);
            if(isPalindrome(left)){
                right = s.substring(i);
                helper(start + 1, right, count + 1); 
            }
        }
    }
    /**/
    /*DP Accepted Answer*/
    public static int minCut(String s){ 
        boolean[][] dict = new boolean[s.length()][s.length()];
        for(int i = s.length() - 1;i >= 0;i--){
            for(int j = i;j < s.length();j++){
                if(s.charAt(i) == s.charAt(j) && ((j - i) < 2 || dict[i + 1][j - 1]))
                    dict[i][j] = true;
            }
        }
        int[] d = new int[s.length() + 1];
        d[0] = -1;
        for(int i = 1;i < d.length;i++){
            d[i] = Integer.MAX_VALUE;
            for(int j = 0;j < i;j++){
                //if(isPalindrome(s.substring(j, i)))
                if(dict[j][i - 1])
                    d[i] = Math.min(d[i], d[j] + 1);
            }
        }
        return d[d.length - 1];
    }
    public static boolean isPalindrome(String s){
        for(int i = 0, j = s.length() - 1;i < j;i++,j--){
            if(s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        String test = "fdzkalxdfababababababbbcbababababababababa";
        //String test = "fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi";
        System.out.println("cut:" + minCut(test));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
