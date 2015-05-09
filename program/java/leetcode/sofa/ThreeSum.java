import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] arr, int target) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(arr == null || arr.length <= 2)
            return output;
        Arrays.sort(arr);
        for(int i = arr.length - 1;i >= 2;i--) {
            if(i < arr.length - 1 && arr[i] == arr[i + 1])
                continue;//very important!!
            List<List<Integer>> two = twosum(arr, target - arr[i], i - 1);
            for(List<Integer> x : two) {
                x.add(arr[i]);
            }
            output.addAll(two);
        }
        return output;
    }
    private static List<List<Integer>> twosum(int[] arr, int target, int e) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        for(int i = 0, j = e;i < j;) {
            int sum = arr[i] + arr[j];
            if(sum == target) {
                List<Integer> entry = new ArrayList<Integer>();
                entry.add(arr[i]);
                entry.add(arr[j]);
                output.add(entry);
                i++;
                j--;
                while(i < j && arr[i] == arr[i - 1])
                    i++;
                while(i < j && arr[j] == arr[j + 1])
                    j--;
            }
            else if(sum < target) {
                i++;
            }
            else {
                j--;
            }
        }
        return output;
    }
    public static void main(String[] args) {
        //int[] arr = {1,2,-2,-1};
        int[] arr = {1,2,2,2,100};
        List<List<Integer>> output = threeSum(arr, 5);
        System.out.println(output);
    }
}
