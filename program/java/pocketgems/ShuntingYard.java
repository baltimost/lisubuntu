import java.util.*;

public class ShuntingYard {
    public static void main(String[] args) {
        String exp = "1+2*(4+5)-4";
        System.out.println(con2Postfix(exp));
    }
    public static double evaluateInfix(String exp) {
        return 0.0;
    }

    public static String con2Postfix(String exp) {
        HashMap<Character, Integer> priority = new HashMap<Character, Integer>();
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
        StringBuilder output = new StringBuilder();
        Stack<Character> s = new Stack<Character>();
        for(int i = 0;i < exp.length();i++) {
            char cur = exp.charAt(i);
            if(cur >= '0' && cur <= '9') {
                output.append(cur);
            }
            else if(cur == '(') {
                s.push(cur);
            }
            else if(cur == ')') {
                while(!s.isEmpty() && s.peek() != '(') {
                    output.append(s.pop());
                }
                s.pop();
            }
            else {
                while(!s.isEmpty() && s.peek() != '(' && priority.get(cur) <= priority.get(s.peek())) {
                    output.append(s.pop());
                }
                s.push(cur);
            }
        }
        while(!s.isEmpty()) {
            output.append(s.pop());
        }
        return output.toString();
    }

    public static double evaluatePostfix(String exp) {
        return 0.0;
    }
}
