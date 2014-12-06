import java.util.*;

public class SubsetsII{
    public static List<List<Integer>> subsetsWithDup(int[] num){
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(num == null || num.length == 0)
            return output;
        List<Integer> entry = new ArrayList<Integer>();
        helper(num, 0, entry, output);
        return output;
    }
    public static void helper(
            int[] num,
            int start,
            List<Integer> entry,
            List<List<Integer>> output){
        output.add(new ArrayList<Integer>(entry));
        for(int i = start;i < num.length;i++){
            if(i != start && num[i] == num[i - 1])
                continue;
            entry.add(num[i]);
            helper(num, i + 1, entry, output);
            entry.remove(entry.size() - 1);
        } 
    }
    public static void main(String[] args){
        int[] input = {1,1,3};
        List<List<Integer>> output = subsetsWithDup(input);
        for(List<Integer> x: output){
            for(Integer y: x)
                System.out.print(y + " ");
            System.out.println();
        }
    }
}
