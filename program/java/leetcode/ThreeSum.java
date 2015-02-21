import java.util.*;

public class ThreeSum{
    /*DFS TLE
    public static List<List<Integer>> threeSum(int[] num){
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        List<Integer> entry = new ArrayList<Integer>();
        Arrays.sort(num);
        helper(num, 0, 0, entry, output);
        return output;
    }
    private static void helper(
            int[] num,
            int start,
            int sum,
            List<Integer> entry,
            List<List<Integer>> output){
        if(entry.size() == 3){
            if(sum == 0){
                output.add(new ArrayList<Integer>(entry));
                return;
            }
        }
        else if(start == num.length)
            return;

        for(int i = start;i < num.length;i++){
            if(i != start && num[i] == num[i - 1]) 
                continue;
            entry.add(num[i]);
            helper(num, i + 1, sum + num[i], entry, output);
            entry.remove(entry.size() - 1);
        }
    }
    */
    /**/
    public static List<List<Integer>> threeSum(int[] num){
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        List<Integer> entry;
        Arrays.sort(num);
        for(int k = 0;k < num.length;k++){
            if(k != 0 && num[k] == num[k - 1]) continue;
            for(int i = k + 1, j = num.length - 1;i < j;){
                int sum = num[i] + num[j] + num[k];
                if(sum == 0){
                    entry = new ArrayList<Integer>();
                    entry.add(num[k]);
                    entry.add(num[i]);
                    entry.add(num[j]);
                    output.add(entry);
                    i++;
                    j--;
                    while(i < j && num[i] == num[i - 1]) i++;
                    while(i < j && num[j] == num[j + 1]) j--;
                } 
                else if(sum < 0){
                    i++;
                }
                else{
                    j--;
                }
            }
        } 
        return output;
    }
    public static void main(String[] args){
        //int[] input = {-2,0,0,2,2};
        int[] input = {0,0,0};
        //int[] input = {-1,0,1,2,-1,-4};
        //int[] input = {1,7,5,5,-2,1,7,9,4,-8,3,-8,-6,-10,3,3,9,-1,-1,-5,9,-5,-6,-9,3,-7,7,20,19,18,17,16};
        long before = System.currentTimeMillis();
        List<List<Integer>> output = threeSum(input); 
        long after = System.currentTimeMillis();
        long interval = after - before;
        for(List<Integer> x: output){
            for(Integer y: x)
                System.out.print(y + " ");
            System.out.println();
        }
        System.out.println(interval);
    }
}
