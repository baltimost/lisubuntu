import java.util.HashMap;

public class TwoSum {
    public static int[] twosum(int[] arr, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int[] output = {-1, -1};
        for(int i = 0;i < arr.length;i++) {
            if(hm.containsKey(target - arr[i])) {
                int index = hm.get(target - arr[i]);
                output[0] = index > i ? i : index; 
                output[1] = index < i ? i : index; 
                return output;
            }
            else
                hm.put(i, arr[i]);
        }
        return output;
    }
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,7,9};
        int[] output = new int[2];
        output = TwoSum.twosum(arr, 9);
        System.out.println(output[0] +" " + output[1]);
        int[] array = new int[2];
        System.out.println(array[0] + " " + array[1]);
    }
}
