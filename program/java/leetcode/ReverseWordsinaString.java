import java.util.*;

public class ReverseWordsinaString{
    /*
    public static String reverseWords(String s){
        Stack<String> stack = new Stack<String>();
        StringBuilder output = new StringBuilder("");
        String word = "";
        boolean started = false;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) != ' '){
                started = true;
                word += s.charAt(i);
            } 
            else if(started){
                started = false;
                stack.push(word);
                word = "";
            }
        }
        if(started)
            stack.push(word);
        
        while(!stack.isEmpty()){
            output.append(stack.pop());
            if(!stack.isEmpty())
                output.append(" ");
        }
        return output.toString();
    }
    */
    public static String reverseWords(String s){
        if(s == null)
            return null;
        Stack<String> st = new Stack<String>();
        String word = "";
        StringBuilder output = new StringBuilder("");
        int i = 0, j = 0;
        for(;j < s.length();j++){
            if(s.charAt(j) == ' '){
                if(s.charAt(i) != ' '){//if space
                    st.push(s.substring(i,j));
                    i = j;
                }
                i++;
            }
        }
        if(i < s.length())
            st.push(s.substring(i,j));
        while(!st.isEmpty()){
            output.append(st.pop());
            if(!st.isEmpty())
                output.append(" ");
        }
        return output.toString();

    }
    public static void main(String[] args){
//        String test = "hwf akgsvxoum.srls!q?kzn,eobptjwuzprb?pcvgzf wbf,aaouridwjwtsc'niveqfkpozoobgi";
        String test ="  To be   continued";
        System.out.println(test);
        System.out.println(reverseWords(test));
    }
}
