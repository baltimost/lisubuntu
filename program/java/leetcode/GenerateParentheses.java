import java.util.*;

public class GenerateParentheses{
    /*
    ArrayList<String> output = new ArrayList<String>();
    public ArrayList<String> generateParenthesis(int n) {
        if(n <= 0) {
            return output;
        }
        generate("", n, n);
        return output;
    }

    public void generate(String s, int left, int right) {
        if(left == 0 && right == 0) {
            output.add(s);
            return;
        }
        if(left > 0)
            generate(s + "(", left - 1, right);
        if(left < right)
            generate(s + ")", left, right - 1);
    }
    */
    public ArrayList<String> generateParenthesis(int n){
        ArrayList<String> output = new ArrayList<String>();
        if(n <= 0) return output;
        StringBuilder entry = new StringBuilder();
        helper(entry, output, n, n);
        return output;
    }
    private void helper(StringBuilder entry, ArrayList<String> output, int left, int right){
        if(left == 0 && right == 0){
            output.add(entry.toString());
            return;
        }
        if(left > 0){
            entry.append("(");
            helper(entry, output, left - 1, right);
            entry.deleteCharAt(entry.length() - 1);
        }
        if(left < right){
            entry.append(")");
            helper(entry, output, left, right - 1);
            entry.deleteCharAt(entry.length() - 1);
        }
    }

    public static void main(String[] args){
        GenerateParentheses gp = new GenerateParentheses();
        ArrayList<String> output = gp.generateParenthesis(3);
        for(String x:output)
            System.out.println(x);
    }
}
