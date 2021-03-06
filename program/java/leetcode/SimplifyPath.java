import java.util.*;

public class SimplifyPath{
    /* Using split
    public static String simplifyPath(String path){
        String[] directories = path.split("/");
        Stack<String> stack = new Stack<String>();
        StringBuilder output = new StringBuilder();
        for(int i = 0;i < directories.length;i++){
            if(directories[i].equals("") || directories[i].equals("."))
                continue;
            else if(directories[i].equals("..")){
                if(stack.isEmpty())
                    continue;
                else
                    stack.pop();
            }
            else{
                System.out.println("hao");
                stack.push(directories[i]);
            }
        }
        if(stack.isEmpty())
            return "/";
        while(!stack.isEmpty()){
            output.insert(0,"/" + stack.pop());
        }
        return output.toString();
    }
    */
    /*Not using split*/
    public static String simplifyPath(String path){
        Stack<String> stack = new Stack<String>();
        int i = 0, j;
        while(i < path.length() && path.charAt(i) == '/') i++;
        for(j = i + 1;j <= path.length();j++){
            if(j == path.length() || path.charAt(j) == '/'){
                String folder = path.substring(i, j);
                if(folder.equals("..")){
                    if(!stack.isEmpty()) stack.pop();
                }
                else if(!folder.equals("") && !folder.equals("."))
                    stack.push(folder);
                i = j + 1;
            }
        }
        if(stack.isEmpty()) return "/";
        
        Stack<String> reverse = new Stack<String>();
        while(!stack.isEmpty())
            reverse.push(stack.pop());

        StringBuilder output = new StringBuilder();
        while(!reverse.isEmpty())
            output.append("/" + reverse.pop());
        return output.toString();
    }
    public static void main(String[] args){
        //String path = "/...//foo/././";
        String path = "/home//foo/././../";
        System.out.println(simplifyPath(path));
    }
}
