import java.util.Arrays;
public class ThreeSumClosestnew{
    public static int ThreeSumClosest(int[] arr, int sum){
        if(arr == null || arr.length <= 2) return Integer.MIN_VALUE;
        int minGap = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i = arr.length - 1;i >= 2;i--){

            if(Math.abs(TwoSumClosest(arr, sum - arr[i], i)) < Math.abs(minGap))
                minGap = TwoSumClosest(arr, sum - arr[i], i);
        }  
        return minGap + sum;
    }

    public static int TwoSumClosest(int[] arr, int sum, int len){
        int l = 0;
        int r = len - 1;
        int minGap = Integer.MAX_VALUE;
        while(l < r){
            if(Math.abs(arr[l] + arr[r] - sum) < Math.abs(minGap))
                minGap = arr[l] + arr[r] - sum;
            if(arr[l] + arr[r] == sum) return 0;
            else if(arr[l] + arr[r] > sum) r--;
            else l++;
        }
        return minGap;
    }
    public static void main(String[] args){
        int[] arr = {-3,-2,-5,3,-4};
        System.out.println(ThreeSumClosest(arr, -1));
    }
}
