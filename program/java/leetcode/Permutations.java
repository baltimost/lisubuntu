import java.util.*;

public class Permutations{
    public static List<List<Integer>> permute(int[] num){
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        List<Integer> entry = new ArrayList<Integer>();
        boolean[] visited = new boolean[num.length];
        helper(num, visited,  entry, output);
        return output;
    }
    public static void helper(
            int[] num,
            boolean[] visited,
            List<Integer> entry,
            List<List<Integer>> output
            ){
        if(entry.size() == num.length){
            output.add(new ArrayList<Integer>(entry));
            return;
        }
        for(int i = 0;i < num.length;i++){
            if(visited[i])
                continue;
            entry.add(num[i]);
            visited[i] = true;
            helper(num, visited, entry, output);
            entry.remove(entry.size() - 1);
            visited[i] = false;
        }
    }
    public static void main(String[] args){
        int[] intput = {1, 2, 3};
        List<List<Integer>> output = permute(intput);
        for(List<Integer> x: output){
            for(Integer y: x)
                System.out.print(y + " ");
            System.out.println();
        }
    }
}
