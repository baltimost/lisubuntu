public class MaximumProductSubarray{
    public static int maxProduct(int[] A){
        if(A == null || A.length == 0)
            return 0;
        int max = 0;
        int curr = 0;
        int candidate = 0;
        for(int i = 0;i < A.length;i++){
            if(i == 0){
                max = A[0];
                curr = A[0];
                candidate = A[0];
            }
            else{
                curr *= A[i];
                candidate *= A[i];
                max = Math.max(max, Math.max(curr, candidate));
            }
            if(A[i] == 0){
                curr = 1;
                candidate = 1;
            }
            else if(A[i] < 0)
                curr = 1;
        }
        return max;
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
