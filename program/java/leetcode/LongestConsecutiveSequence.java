import java.util.*;

public class LongestConsecutiveSequence{
    public static int longestConsecutive(int[] num){
        if(num == null || num.length == 0)
            return 0;
        int output = Integer.MIN_VALUE;
        Set<Integer> s = new HashSet<Integer>();
        for(int x: num)
            s.add(x);
        for(int i = 0;i < num.length && !s.isEmpty();i++){
            int sum = 0;
            for(int x = num[i];s.contains(x);x++){
                sum++;
                s.remove(x);
            }
            for(int x = num[i] - 1;s.contains(x);x--){
                sum++;
                s.remove(x);
            }
            output = Math.max(output, sum); 
        }
        return output;
    }
    public static void main(String[] args){
        int[] test = {9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println(longestConsecutive(test));
    }
}
