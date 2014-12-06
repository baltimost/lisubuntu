import java.util.*;

public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        if(s == null)
            return 0;
        int curLen = 0;
        int sumLen = 0;
        int output = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '(')
                stack.push(i);
            else if(stack.isEmpty()){
                sumLen = 0;
            }
            else{
                int matchedPos = stack.pop();
                int curlen = i - matchedPos + 1;
                if(stack.isEmpty()){
                    sumLen += sumLen + curlen;
                    curlen = sumLen;
                }
                else{
                    curlen = i - stack.peek();
                }
                output = output > curlen? output : curlen; 
            }
        }
        return output;
    }
    public static void main(String[] args){
        String test = "(()(()";
        String test2 = "())()";
        String test3 = "()(()";
        String test4 = "(()())";
        System.out.println(longestValidParentheses(test));
        System.out.println(longestValidParentheses(test2));
        System.out.println(longestValidParentheses(test3));
        System.out.println(longestValidParentheses(test4));
    }
}
