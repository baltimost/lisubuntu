import java.util.*;

public class ThreeSumClosest{
    public static int threeSumClosest(int[] num, int target){
        int distance = Integer.MAX_VALUE;
        int output = target;

        Arrays.sort(num);
        for(int k = 0;k < num.length - 2;k++){
            if(k != 0 && num[k] == num[k - 1]) continue;
            int i, j, sum;
            for(i = k + 1, j = num.length - 1;i < j;){
                sum = num[k] + num[i] + num[j];
                if(Math.abs(target - sum) < distance){
                    distance = Math.abs(target - sum);
                    output = sum;
                }
                if(sum == target)
                    return target;
                else if(sum > target)
                    j--;
                else
                    i++;
            }
        } 
        return output;
    }
    public static int threeSumClosestAlt(int[] num, int target){
        Arrays.sort(num);
        Integer output = null;
        for(int i = 0;i < num.length - 2;i++){
            int two = twoSumClosest(num, target - num[i], i + 1);
            output = output == null || Math.abs(two + num[i] - target) < Math.abs(output - target) ? two + num[i] : output;
        }
        return output;
    }
    private static int twoSumClosest(int[] num, int target, int start){
        Integer output = null;
        for(int i = start, j = num.length - 1;i < j;){
            int cur = num[i] + num[j];
            output = output == null || Math.abs(target - cur) < Math.abs(target - output) ? cur : output;
            if(cur == target)
                return output;
            else if(cur < target)
                i++;
            else
                j--;
        } 
        return output;
    }
    public static void main(String[] args){
        //int[] input = {-1,2,1,-4};
        //int[] input = {1,1,1,0};
        int[] input = {-3,-2,-5,3,-4};
        System.out.println(threeSumClosest(input, -1));
        for(int x : input)
            System.out.print(x + " ");
        System.out.println();
        System.out.println(threeSumClosestAlt(input, -1));
    }
}
