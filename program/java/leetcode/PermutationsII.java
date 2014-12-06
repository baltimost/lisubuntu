import java.util.*;

public class PermutationsII{
    public static List<List<Integer>> permuteUnique(int[] num){
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(num == null || num.length == 0)
            return output;
        List<Integer> entry = new ArrayList<Integer>();
        boolean[] visited = new boolean[num.length];
        Arrays.sort(num);
        helper(num, entry, output, visited);
        return output;
    }
    public static void helper(
            int[] num,
            List<Integer> entry,
            List<List<Integer>> output,
            boolean[] visited){
        if(entry.size() == num.length){
            output.add(new ArrayList<Integer>(entry));
            return;
        }
        for(int i = 0;i < num.length;i++){
            if(visited[i] || i != 0 && num[i] == num[i - 1] && !visited[i - 1])
                continue;
            visited[i] = true;
            entry.add(num[i]);
            helper(num, entry, output, visited);
            entry.remove(entry.size() - 1);
            visited[i] = false;
        }
    }
    public static void main(String[] args){
        int[] input = {1,1,2};
        List<List<Integer>> output = permuteUnique(input); 
        for(List<Integer> x: output){
            for(Integer y: x)
                System.out.print(y + " ");
            System.out.println();
        }
    }
}
