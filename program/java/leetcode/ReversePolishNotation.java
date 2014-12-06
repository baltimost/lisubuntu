import java.util.*;

public class ReversePolishNotation{
    public static int evalRPN(String[] tokens){
        if(tokens == null || tokens.length < 3)
            return 0;
        Stack<Integer> st = new Stack<Integer>();
        String operators = "+-*/";
        for(int i = 0;i < tokens.length;i++){
            int left, right;
            if(!operators.contains(tokens[i])){
                st.push(Integer.parseInt(tokens[i]));
                continue;
            }
            right = st.pop();
            left = st.pop();
            switch(tokens[i]){
                case "+":
                    st.push(left + right);
                    break;
                case "-":
                    st.push(left - right);
                    break;
                case "*":
                    st.push(left * right);
                    break;
                case "/":
                    st.push(left / right);
                    break;
            } 
        }
        return st.pop();
    }
    public static void main(String[] args){
        //String[] test1 = {"2","1","+","3","*"};
        String[] test2 = {"4","13","5","/","+"};
        //System.out.println(evalRPN(test1));
        System.out.println(evalRPN(test2));
    }

}
