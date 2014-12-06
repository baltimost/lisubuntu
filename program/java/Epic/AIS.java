import java.util.ArrayList;
import java.util.List;

public class AIS{
    public static List<List<Integer>> findAllIS(int[] arr){
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        List<Integer> entry = new ArrayList<Integer>();
        helper(arr, 0, entry, output);
        return output;
    }
    private static void helper(int[] arr, int start, List<Integer> entry, List<List<Integer>> output){
        if(entry.size() >= 2){
            output.add(new ArrayList<Integer>(entry));
        }
        for(int i = start;i < arr.length;i++){
            if(entry.size() != 0 && arr[i] <= entry.get(entry.size() - 1))
                continue;
            entry.add(arr[i]);
            helper(arr, i + 1, entry, output);
            entry.remove(entry.size() - 1);
        }
    }
    public static void main(String[] args){
        //int[] arr = {1,2,3,4};
        int[] arr = {5,4,7,8,2,3,6,9,8,6,2,3,4,5};
        List<List<Integer>> rst = findAllIS(arr);
        for(List<Integer> x : rst){
            for(Integer y : x)
                System.out.print(y + " ");
            System.out.println();
        }
    }
}
