import java.util.*;

public class Sofa{
    public static String simplifypath(String str){
        Stack<String> s = new Stack<String>();
        int i = 0, j;
        while(str.charAt(i) == '/')
           i++; 
        for(j = i;j <= str.length();j++){
            if(j == str.length() || str.charAt(j) == '/'){
                String cur = str.substring(i, j);
                System.out.println(cur);
                if(cur.equals("..")){ 
                    if(!s.isEmpty())
                        s.pop();
                }
                else if(!cur.equals(".") && !cur.equals(""))
                    s.push(cur);
                i = j + 1;
            }
        }
        System.out.println(s.size());
        Stack<String> reverse = new Stack<String>();
        while(!s.isEmpty())
            reverse.push(s.pop());
        StringBuilder output = new StringBuilder();
        while(!reverse.isEmpty()){
            output.append("/" + reverse.pop());
        }
        return output.toString();
    }
    public static void main(String[] args){
        String str = "/ak/b////c/d/./../../k/../last/../../../..";
        System.out.println(str);
        System.out.println(simplifypath(str));
    }
}

