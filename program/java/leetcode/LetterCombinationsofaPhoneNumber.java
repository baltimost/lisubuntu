import java.util.*;

public class LetterCombinationsofaPhoneNumber{
    public static List<String> letterCombinations(String digits){
        String[] letters = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder entry = new StringBuilder();
        List<String> output = new ArrayList<String>();
        helper(letters, digits, 0, entry, output);
        return output;
    }
    public static void helper(
           String[] letters,
           String digits,
           int start,
           StringBuilder entry,
           List<String> output){
        /*
        if(entry.length() == digits.length()){
            output.add(entry.toString());
            return;
        }
        for(int i = start;i < digits.length();i++){
            int th = digits.charAt(i) - '0';
            for(int j = 0;j < letters[th].length();j++){
                entry.append(letters[th].charAt(j));
                helper(letters, digits, i + 1, entry, output);
                entry.deleteCharAt(entry.length() - 1);
            }
        }
        */
        /**/
        // Three Times faster than above, 'Cause above generates redundant entries, 
        // if I input "234", it may skip 3
        if(start == digits.length()){
            output.add(entry.toString());
            return;
        }
        int index = digits.charAt(start) - '0';
        for(int j = 0;j < letters[index].length();j++){
            entry.append(letters[index].charAt(j));
            helper(letters, digits, start + 1, entry, output);
            entry.deleteCharAt(entry.length() - 1);
        }
        /**/
    } 
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        List<String> output = letterCombinations("234");
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        /*
        for(String x: output)
            System.out.println("**"+x+"**");
            */
    }
}
