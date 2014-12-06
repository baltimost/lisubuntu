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
    public static void main(String[] args){
        //int[] input = {-1,2,1,-4};
        int[] input = {1,1,1,0};
        System.out.println(threeSumClosest(input, -100));
    }
}
