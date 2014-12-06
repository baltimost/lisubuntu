public class MaxConSubSeq{
    public static int maxConSubSeq(int[] arr){
        int output = 0;
        int sum = 0;
        for(int i = 0;i < arr.length;i++){
            sum += arr[i];
            output = Math.max(output, sum);
            if(sum < 0)
                sum = 0;
        }
        return output;
    }
    public static int[] maxConSubSeqIndex(int[] arr){
        int[] output = {0,0};
        int maxSum = 0;
        int sum = 0;
        int start = 0;
        for(int i = 0;i < arr.length;i++){
            sum += arr[i];
            if(sum > maxSum){
                maxSum = sum;
                output[0] = start;
                output[1] = i; 
            }
            if(sum < 0){
                sum = 0;
                start = i + 1;
            }
        }
        return output;
    }
    public static void main(String[] args){
        int[] input = {2,3,-2,4,-8,8,9,-2,10};
        int[] rst = maxConSubSeqIndex(input);
        System.out.println(rst[0] + "," + rst[1]);
    }
}
