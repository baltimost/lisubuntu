import java.util.HashMap;

public class TwoSum{
    public static int[] twoSum(int[] numbers, int target){
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        int[] output = new int[2];
        for(int i = 0;i < numbers.length;i++){
            if(hs.get(target - numbers[i]) == null)
                hs.put(numbers[i], i);
            else{
                int j = hs.get(target - numbers[i]);
                output[0] = j; 
                output[1] = i;
                return output;
            }
        }
        return output;
    }
    public static void main(String[] args){
        //int[] input = {7,7,11,15};
        //int[] output = twoSum(input, 14); 
        int[] input = {3,2,4};
        int[] output = twoSum(input, 6); 
        System.out.println(output[0] + " " + output[1]);
    }
}
