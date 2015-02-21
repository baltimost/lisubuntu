import java.util.*;

public class FourSum{
    public static List<List<Integer>> fourSum(int[] num, int target){
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        List<Integer> entry;
        Arrays.sort(num);
        for(int h = 0;h < num.length - 3;h++){
            if(h != 0 && num[h] == num[h - 1]) continue;
            for(int k = h + 1;k < num.length - 2;k++){
                if(num[k] == num[k - 1]) continue;
                for(int i = k + 1, j = num.length - 1;i < j;){
                    int sum = num[h] + num[k] + num[i] + num[j];
                    if(sum == target){
                        entry = new ArrayList<Integer>();
                        entry.add(num[h]);
                        entry.add(num[k]);
                        entry.add(num[i]);
                        entry.add(num[j]);
                        output.add(entry);
                        i++;
                        j--;
                        while(i < j && num[i] == num[i - 1]) i++;
                        while(i < j && num[j] == num[j + 1]) j--;
                    }
                    else if(sum > target)
                        j--;
                    else
                        i++;
                }
            }
        }
        return output;
    }
    public static void main(String[] args){
        //int[] arr = {1,0,-1,0,-2,2};
        int[] arr = {5,2,4,6,7,1,2,11,6};
        List<List<Integer>> output = fourSum(arr, 17);
        for(List<Integer> x: output){
            for(Integer y: x)
                System.out.print(y + " ");
            System.out.println();
        }
    }
}
