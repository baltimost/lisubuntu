import java.util.*;

public class PalindromePartitioning{
    public List<List<String>> partition(String s){
        if(s == null)
            return null;
        List<List<String>> output = new ArrayList<List<String>>();
        List<String> combination = new ArrayList<String>();
        helper(output, 0, combination, s);
        return output;
    }
    private void helper(List<List<String>> output, int level, List<String> combination, String s){
        if(s.equals("")){
            output.add(new ArrayList<String>(combination));
            return;
        }
        String left, right;
        for(int i = 1;i <= s.length();i++){
            left = s.substring(0,i);
            if(isPalindrome(left)){
                /*
                if(level >= combination.size())
                    combination.add(left);
                else
                    combination.set(level, left);
                right = s.substring(i);
                helper(output, level + 1, combination, right);
                for(int j = level + 1;j < combination.size();j++)
                    combination.remove(j);
                    */
                combination.add(left);
                right = s.substring(i);
                helper(output, level + 1, combination, right);
                combination.remove(combination.size() - 1);
            } 
        }
    } 
    public boolean isPalindrome(String s){
        for(int i = 0, j = s.length() - 1;i < j;i++,j--){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args){
        PalindromePartitioning pp = new PalindromePartitioning();
        String test = "aab";
        List<List<String>> rst = pp.partition(test);
        for(List<String> x: rst){
            for(String y: x)
                System.out.print(y + " ");
            System.out.println();
        }
    }
}
