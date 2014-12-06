import java.util.*;

public class CombinationSumII{
    public static List<List<Integer>> combinationSum2(int[] num, int target){
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        List<Integer> entry = new ArrayList<Integer>();
        Arrays.sort(num);
        helper(num, target, 0, entry, output);
        return output;
    }
    private static void helper(
            int[] num,
            int target,
            int start,
            List<Integer> entry,
            List<List<Integer>> output){
        if(target <= 0){
            if(target == 0)
                output.add(new ArrayList<Integer>(entry));
            return;
        }
        for(int i = start;i < num.length;i++){
            //System.out.println("start=" + start+"i=" + i);
            if(i > start && num[i] == num[i - 1]){
                System.out.println("hao");
                continue;
            }
            entry.add(num[i]);
            helper(num, target - num[i], i + 1, entry, output);
            entry.remove(entry.size() - 1);
        }
    }
    public static void main(String[] args){
        int[] input = {1,1};
        List<List<Integer>> output = combinationSum2(input, 2);
        for(List<Integer> x: output){
            for(Integer y: x)
                System.out.print(y + " ");
            System.out.println();
        }
    }
}
