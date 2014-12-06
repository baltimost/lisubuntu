import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class ValidPhoneNumbers{
    public static List<String> printValidNumbers(int n, char[] invalid){
        List<String> output = new ArrayList<String>();
        StringBuilder entry = new StringBuilder();
        HashSet<Character> hs = new HashSet<Character>();
        for(Character x : invalid)
            hs.add(x);
        helper(n, hs, entry, output);
        return output;
    }
    private static void helper(int n, HashSet<Character> invalid, StringBuilder entry, List<String> output){
        if(entry.length() == n){
            output.add(entry.toString());
            return;
        }
        for(char i = '0';i < '9';i++){
            if(
                    invalid.contains((char)i) || 
                    (entry.length() != 0 && ((char)i == '4' || (char)i == entry.charAt(entry.length() - 1 )))
                    )
                continue;
            entry.append((char)i);
            helper(n, invalid, entry, output);
            entry.deleteCharAt(entry.length() - 1);
        }
    }
    public static void main(String[] args){
        char[] invalid = {'7','2','9'};
        List<String> rst = printValidNumbers(10, invalid);
    }
}
