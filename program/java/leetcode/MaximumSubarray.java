public class MaximumSubarray{
    public static int maxSubArray(int[] A){
        int max= Integer.MIN_VALUE;
        int cur = 0;
        for(int i = 0;i < A.length;i++){
            cur += A[i];
            max = Math.max(max, cur);
            if(cur < 0)
                cur = 0;
        }
        return max;
    }
    //i = 1000000 27ms*/
    //return indexes
    public static int[] maxSubArrayAlt(int[] A){
        int max = Integer.MIN_VALUE;
        int cur = 0;
        int curl = 0;
        int maxl = 0;
        int maxr = 0;
        for(int i = 0;i < A.length;i++){
            cur += A[i];
            if(cur > max){
                max = cur;
                maxl = curl;
                maxr = i;
            }
            if(cur <= 0){
                cur = 0;
                curl = i + 1;
            }
        }
        return new int[]{maxl, maxr};
    }

    /*Dynamic Programming i = 1000000 78ms
    public static int maxSubArray(int[] A){
        int[] d = new int[A.length];
        d[0] = A[0];
        int maxSum = d[0]; 
        for(int i = 1;i < A.length;i++){
            d[i] = A[i] > A[i] + d[i - 1] ? A[i] : A[i] + d[i - 1]; 
            maxSum = maxSum > d[i] ? maxSum : d[i];
        }
        return maxSum;
    }
    */
    

    /*Divide and Conquer
    public static int maxSubArray(int[] A){
        if(A == null || A.length == 0)
            return 0;
        return helper(A, 0, A.length - 1);
    }
    public static int helper(int[] A, int h, int t){
        if(h == t)
            return A[h];
        int m = (h + t) / 2;
        //int m = t / 2;
        return Math.max(
                Math.max(helper(A, h, m), helper(A, m + 1, t)),
                maxCrossingSum(A, h, m, t)
                );  
    }
    public static int maxCrossingSum(int[] A, int h, int m, int t){
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE; 
        for(int i = m, sum = 0; i >= h; i--){
            sum += A[i];
            leftSum = Math.max(sum, leftSum);
        }
        for(int i = m + 1, sum = 0; i <= t; i++){
            sum += A[i];
            rightSum = Math.max(sum, rightSum);
        }
        return leftSum + rightSum;
    } 
    */

    public static void main(String[] args){
        //int[] test = {-2,1};
        //int[] test = {-2,1,-3,4,-1,2,1,-5,4};
        int[] test = {-1,2,-1,2,-1,2,-1,2,-1,2,-1,2,-3,-7,4,-2};
        //int[] test = {-2,-1,-3,-4};
        long bt = System.currentTimeMillis();
        long at, interval;
        /*
        for(int i = 0;i < 1000000;i++)
            maxSubArray(test);
            */
        System.out.println(maxSubArray(test));
        int[] rst = maxSubArrayAlt(test);
        System.out.println(rst[0] + "," + rst[1]);
        at = System.currentTimeMillis();
        interval = at - bt;
        System.out.println(interval);
    }
}
