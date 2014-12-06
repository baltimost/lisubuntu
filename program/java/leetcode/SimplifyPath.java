import java.util.*;

public class SimplifyPath{
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
    public static void main(String[] args){
        String path = "/...//foo/././";
        //String path = "/home//foo/././../";
        System.out.println(simplifyPath(path));
    }
}
