import java.util.*;

public class Subsets{
    //iterative:
    public static List<List<Integer>> subsets(int[] S){
        Arrays.sort(S);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        for(int i = 0;i < S.length;i++){
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            for(List<Integer> prevSubset : result){
                List<Integer> newSubset = new ArrayList<Integer>();
                newSubset.addAll(prevSubset);
                newSubset.add(S[i]);
                temp.add(newSubset);
            }
            result.addAll(temp);
        }
        return result;
    }
    /*
    public static List<List<Integer>> subsets(int[] S){
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(S == null || S.length == 0)
            return output;
        List<Integer> entry = new ArrayList<Integer>();
        //for(int i = 0;i <= S.length;i++){
            helper(S, 0, entry, output);
        //} 
        return output;
    }
    */ 
    public static void helper(
            int[] S, 
            //int k,
            int start,
            List<Integer> entry,
            List<List<Integer>> output){
       // if(entry.size() == k){
            output.add(new ArrayList<Integer>(entry));
        //    return;
        //}
        for(int i = start;i < S.length;i++){
            entry.add(S[i]);
            helper(S, i + 1, entry, output);
            entry.remove(entry.size() - 1);
        }
    }
    public static void main(String[] args){
        int[] input = {1,2,3};
        List<List<Integer>> output = subsets(input);
        for(List<Integer> x: output){
            for(Integer y: x)
                System.out.print(y + " ");
            System.out.println();
        }
    }
}
