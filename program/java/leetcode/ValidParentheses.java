import java.util.*;

public class ValidParentheses{
    public static boolean isValid(String s){
        HashMap<Character, Character> pair = new HashMap<Character, Character>();
        pair.put('(',')');
        pair.put('{','}');
        pair.put('[',']');
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length();i++){
            char character = s.charAt(i);
            switch(character){
                case '(':
                case '{':
                case '[':
                    stack.push(character);
                    break;
                case ')':
                case '}':
                case ']':
                    if(stack.isEmpty() || (pair.get(stack.pop()) != character))
                    return false;

            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        String line1 = "Encryption scheme K{K2[3]world(3)}";
        String line2 = "Encryption scheme K{K2[3world(3)]}";
        String line3 = "(Encryption scheme K{K2[3world(3)]}";
        String line4 = "Encryption s)cheme K{K2[3world(3)]}";
        String line5 = "Encryption scheme K{K2[3world(3)]}haya}";
        String line6 = "([)]";
        System.out.println(isValid(line1));
        System.out.println(isValid(line2));
        System.out.println(isValid(line3));
        System.out.println(isValid(line4));
        System.out.println(isValid(line5));
        System.out.println(isValid(line6));
    }
}
