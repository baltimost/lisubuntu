import java.util.List;
import java.util.ArrayList;

public class PasswordPerm{
    public static List<String> permPassword(String password){
        List<String> output = new ArrayList<String>();
        StringBuilder entry = new StringBuilder();
        boolean[] visited = new boolean[password.length()];
        helper(password, entry, output, visited);
        return output;
    }

    private static void helper(String password, StringBuilder entry, List<String> output, boolean[] visited){
        if(entry.length() == password.length()){
            output.add(entry.toString());
            return;
        }
        for(int i = 0;i < password.length();i++){
            if(visited[i] || i != 0 && password.charAt(i) == password.charAt(i - 1) && !visited[i - 1])
                continue;
            entry.append(password.charAt(i));
            visited[i] = true;
            helper(password, entry, output, visited);
            entry.deleteCharAt(entry.length() - 1);
            visited[i] = false;
        }
    }
    public static void main(String[] args){
        //List<String> rst = permPassword("123");
        List<String> rst = permPassword("0223");
        for(String x : rst)
           System.out.println(x);
    }
}
