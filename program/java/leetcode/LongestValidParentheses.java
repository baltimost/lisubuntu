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
                if(stack.isEmpty()){
                    sumLen += i - matchedPos + 1; 
                    curLen = sumLen;
                }
                else{
                    curLen = i - stack.peek();
                }
                output = Math.max(output, curLen);
            }
        }
        return output;
    }
    public static int longestValidParenthesesAlt(String s) {
    }
    public static void main(String[] args){
        String test = "(()(()";
        String test2 = "())()";
        String test3 = "()(()";
        String test4 = "(()())";
        String test5 = "()()";
        System.out.println(longestValidParentheses(test));
        System.out.println(longestValidParentheses(test2));
        System.out.println(longestValidParentheses(test3));
        System.out.println(longestValidParentheses(test4));
        System.out.println(longestValidParentheses(test5));
System.out.println();
        System.out.println(longestValidParenthesesAlt(test));
        System.out.println(longestValidParenthesesAlt(test2));
        System.out.println(longestValidParenthesesAlt(test3));
        System.out.println(longestValidParenthesesAlt(test4));
        System.out.println(longestValidParenthesesAlt(test5));
    }
}
