import java.util.*;

public class ReverseWordsinaString{
    /*Two passes
    public static String reverseWords(String s){
        if(s == null)
            return null;
        Stack<String> st = new Stack<String>();
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
    */
    /*One pass*/
    public static String reverseWords(String s){
        if(s == null)
            return s; 
        Stack<String> stack = new Stack<String>();
        StringBuilder output = new StringBuilder();
        int i = s.length() - 1;
        while(i >= 0 && s.charAt(i) == ' ') i--;
        for(int j = i + 1;i >= -1;i--){
            if(i == - 1 || s.charAt(i) == ' '){
                if(s.charAt(i + 1) != ' ')
                    output.append(s.substring(i + 1, j) + " ");
                j = i;
            }
        }
        if(output.length() >= 1)
            output.deleteCharAt(output.length() - 1);
        return output.toString();
    }
    public static void main(String[] args){
//        String test = "hwf akgsvxoum.srls!q?kzn,eobptjwuzprb?pcvgzf wbf,aaouridwjwtsc'niveqfkpozoobgi";
        //String test ="  To be   continued";
        //String test ="To be   continued";
        //String test ="c";
        String test = " ";
        System.out.println(test);
        System.out.println("**" + reverseWords(test) + "**");
    }
}
