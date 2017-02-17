public class MaximumProductSubarray{
    public static int maxProduct(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int max = A[0];
        int min = A[0];
        int output = A[0];
        for(int i = 1;i < A.length;i++) {
            int tmp = max;
            max = Math.max(A[i], Math.max(max * A[i], min * A[i]));
            min = Math.min(A[i], Math.min(tmp * A[i], min * A[i]));
            output = Math.max(output, max);
        }
        return output;
    }
    public static void main(String[] args){
        //int[] arr = {5,4,3,8,-5,4,2,-4,2,-3,7,8,6,9};
        int[] arr = {0,0,4};
        System.out.println(maxProduct(arr));
        int[] arr1 = {0,0,0};
        System.out.println(maxProduct(arr1));
        int[] arr2 = {0,-1,0};
        System.out.println(maxProduct(arr2));
        int[] arr3 = {-2};
        System.out.println(maxProduct(arr3));
        int[] arr4 = {0,2};
        System.out.println(maxProduct(arr4));
    }
}
