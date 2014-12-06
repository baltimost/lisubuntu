import java.util.*;

public class Combinations{
    public static List<List<Integer>> combine(int n, int k){
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        List<Integer> entry = new ArrayList<Integer>();
        helper(n, k, 1, entry, output);
        return output;
    }
    public static void helper(
            int n, 
            int k, 
            int start,
            List<Integer> entry,
            List<List<Integer>> output){
        System.out.println("hao");
        if(entry.size() == k){
            output.add(new ArrayList<Integer>(entry));
            return;
        }           
        for(int i = start;i <= n;i++){
            entry.add(i);
            helper(n, k, i + 1, entry, output);
            entry.remove(entry.size() - 1);
        }
    }
    public static void main(String[] args){
        List<List<Integer>> output = combine(44, 55);
        for(List<Integer> x: output){
            for(Integer y: x)
                System.out.print(y + " ");
            System.out.println();
        }
    }
}
