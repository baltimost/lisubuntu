import java.util.List;
import java.util.ArrayList;

public class ExtractUnique{
    /*Apparently BinarySearch is much better(19 times faster) than one pass o(n) approach*/
    public static List<Integer> extractUnique(int[] arr){
        List<Integer> output = new ArrayList<Integer>();
        helper(0, arr.length - 1, arr, output);
        return output;
    }
    public static List<Integer> extractUniqueWorse(int[] arr){
        List<Integer> output = new ArrayList<Integer>();
        for(int i = 0;i < arr.length;i++){
            if(i == 0 || arr[i] != arr[i - 1])
                output.add(arr[i]);
        }
        return output;
    }
    private static void helper(int l, int h, int[] arr, List<Integer> output){
        if(l > h) return;
        if(arr[l] == arr[h]){
            if(output.size() == 0 || output.get(output.size() - 1) != arr[l])
                output.add(arr[l]);
            return;
        }
        int m = (l + h) / 2;
        helper(l, m - 1, arr, output);
        if(output.size() == 0 || output.get(output.size() - 1) != arr[m])
            output.add(arr[m]);
        helper(m + 1, h, arr, output);
    }
    public static void main(String[] args){
        //int[] input = {1,1,3,3,3,5,5,5,9,9,9,9,4,4};
        //int[] input = {1,1,3,3,3,4,4,5,5,5,9,9,9,9};
        //int[] input = {1,1,3,3,3,4,4,5,6,6,6,9,9,9,9};
        int[] input = new int[6553500];
        for(int i = 0;i < 50000;i++)
            input[i] = 1;
        for(int i = 50000;i < 80000;i++)
            input[i] = 3;
        for(int i = 80000;i < 100000;i++)
            input[i] = 4;
        for(int i = 100000;i < input.length;i++)
            input[i] = 8;
        long start = System.currentTimeMillis();
        //List<Integer> rst = extractUnique(input);
        List<Integer> rst = extractUniqueWorse(input);
        long end = System.currentTimeMillis();
        
        for(Integer x : rst)
            System.out.print(x + " ");
        System.out.println();
        System.out.println("Duration:" + (end - start));
    }
}
