import java.util.*;

public class CombinationSum{
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        List<Integer> entry = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, entry, output);
        return output;
    }
    private static void helper(
            int[] candidates,
            int target,
            int start,
            List<Integer> entry,
            List<List<Integer>> output){
        if(target <= 0){
            if(target == 0)
                output.add(new ArrayList<Integer>(entry));
            return;
        }
        for(int i = start;i < candidates.length;i++){
            if(i > start && candidates[i] == candidates[i - 1])
                continue;
            entry.add(candidates[i]);
            helper(candidates, target - candidates[i], i, entry, output);
            entry.remove(entry.size() - 1);
        }
    }
    public static void main(String[] args){
        int[] input = {1,1,1,1,2,2};
        List<List<Integer>> output = combinationSum(input, 7);
        for(List<Integer> x: output){
            for(Integer y: x)
                System.out.print(y + " ");
            System.out.println();
        }
    }
}
