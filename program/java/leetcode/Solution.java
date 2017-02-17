import java.util.*;

public class Solution {
    public List<List<Integer>> 3sum(int[] arr, int target) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        Arrays.sort(arr);
        int n = arr.length;
        for(int i = n - 1;i >= 2;i--) {
            if(i != n - 1 && arr[i] == arr[i + 1]) {
                continue;
            }
            List<List<Integer>> twosum = 2sum(arr, target - arr[i]);
            for(List<Integer> two : twosum) {
                two.add(arr[i]);
            }
            output.addAll(twosum);
        }
        return output;
    }

    public List<List<Integer>> 2sum(int[] arr, int target) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        int n = arr.lenth;
        int l = 0, r = n - 1;
        while(l < r) {
            int sum = arr[l] + arr[r];
            if(sum == target) {
                List<Integer> entry = new ArrayList<Integer>();
                entry.add(arr[l]);
                entry.add(arr[r]);
                output.add(entry);
                l++;
                r--;
                while(l < r && arr[l] == arr[l - 1]) {
                    l++;
                }
                while(l < r && arr[r] == arr[r + 1]) {
                    r--;
                }
            }
            else if(sum < target) {
                l++;
            }
            else {
                r--;
            }
        }
        return output;
    }
}
