import java.util.*;

public class TwoSum{
    public static void main(String[] args){
        //Time measurement
        long bt = System.currentTimeMillis();
        long at;
        long interval;
        //Time measurement
        TwoSum ts = new TwoSum();
        //int[] test = {0,4,3,0,8,2,1,11,23,3,4,2,5,7,8,17,13,15};
        //int target = 22;
        int[] test = {7,7,2,3};
        int target = 14;
        int[] testLim = new int[100000];
        int targetLim = 299998;
        int[] testsim = {3,2,4};
        int targetsim = 6;

        for(int i=0;i<testLim.length;i++)
            testLim[i] = i*2;
        //t:
        bt = System.currentTimeMillis();
        //t:

        int[] output = ts.twoSum(test,target);

        //t:
        at = System.currentTimeMillis();
        interval = at - bt;
        //t:
        System.out.println("duration:"+interval);
        
        System.out.println(output[0]+";"+output[1]);
        System.out.println(test[output[0] - 1]+";"+test[output[1] - 1]);
        //System.out.println(testsim[output[0]-1]);
        //System.out.println(testsim[output[1]-1]);
    }
    /*
    public int[] twoSum(int[] numbers, int target){
        int[] output = new int[2];
        for(int i=0;i<numbers.length-1;i++){
            for(int j = i+1;j<numbers.length;j++){
                if(numbers[i]+numbers[j] == target){
                    output[0] = i+1;
                    output[1] = j+1;
                    return output;
                }
            }
        }
        return output;
    }//6218ms However, that depends, when target is 19998, this one is faster than Hash!!
    */
/*
    public int[] twoSum(int[] numbers, int target){
        int[] output = new int[2];
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0;i<numbers.length;i++)
            hm.put(numbers[i],i);

        for(int i=0;i<numbers.length;i++){
            if(hm.containsKey(target-numbers[i])){
                int j = hm.get(target-numbers[i])+1;
                i = i+1;
                if(i == j)
                    continue;
                output[0] = (i < j) ? i : j;
                output[1] = (i < j) ? j : i;
                return output;
            }
        }
        return output;
    }//hm 38ms//ht 25ms
    */
    public int[] twoSum(int[] numbers, int target){
        int[] output = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i=0;i<numbers.length;i++){
            if(!hm.containsKey(numbers[i])){
                hm.put(target - numbers[i],i);
            }
            else{
                int j = hm.get(numbers[i]) + 1;
                i++;
                output[0] = j < i ? j : i;
                output[1] = j < i ? i : j;
                return output;
            }
        }
        return output;
    }//24ms hm equals ht
    /*More general solution suitable for ThreeSum, but not for this case, 'cause this one requires the indexes
    public int[] twoSum(int[] numbers, int target){
        int[] output = new int[2];
        Arrays.sort(numbers);
        for(int i = 0, j = numbers.length - 1;i < j;){
            int sum = numbers[i] + numbers[j];
            if(sum == target){
                output[0] = numbers[i];
                output[1] = numbers[j];
                return output;
            }
            else if(sum > target)
                j--;
            else
                i++;
        }
        return output;
    }
    */
}
