public class MaxMin{
    public static void maxMin(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < arr.length && arr[i] != 0;i++){
            if(arr[i] % 2 == 0)
                min = Math.min(min, arr[i]);
            else
                max = Math.max(max, arr[i]);
        }
        System.out.println("max odd number is: " + max);
        System.out.println("min even number is: " + min);
    }
    public static void main(String[] args){
        int[] input = {3,2,5,6,5,59,4,53,8,62,0,111,-2};
        maxMin(input);
    }
} 
