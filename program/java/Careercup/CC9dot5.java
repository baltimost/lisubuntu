import java.util.*;

public class CC9dot5{
    public List<String> stringPerm(String str){
        List<String> output = new ArrayList<String>();
        if(str == null) return output;
        StringBuilder entry = new StringBuilder();
        char[] stringArray = str.toCharArray();
        boolean[] visited = new boolean[str.length()];
        helper(stringArray, visited, entry, output);
        return output;
    }
    private void helper(
            char[] stringArray,
            boolean[] visited,
            StringBuilder entry,
            List<String> output){
        output.add(new String(entry.toString()));
        for(int i = 0; i < stringArray.length;i++){
            if(!visited[i]){
                entry.append(stringArray[i]);
                visited[i] = true;
                helper(stringArray, visited, entry, output);
                entry.deleteCharAt(entry.length() - 1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args){
        CC9dot5 cc9dot5 = new CC9dot5();
        String input = "abc";
        List<String> rst = cc9dot5.stringPerm(input);
        for(String x: rst)
            System.out.println(x);
    }

}
