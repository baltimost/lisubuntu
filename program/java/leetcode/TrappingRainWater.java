public class TrappingRainWater{
    public static int trap(int[] A){
        if(A == null || A.length < 3)
            return 0;
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        left[0] = A[0];
        for(int i = 1;i < A.length;i++)
            left[i] = Math.max(A[i], left[i - 1]);
        right[A.length - 1] = A[A.length - 1];

        for(int i = A.length - 2;i >= 0;i--)
            right[i] = Math.max(A[i], right[i + 1]);
        int output = 0;

        for(int i = 1;i < A.length - 1;i++){
            int lowbar = Math.min(left[i - 1], right[i + 1]);
            int tmpwater = Math.max(lowbar - A[i], 0);
            output += tmpwater;
        }

        for(int i = 0;i < A.length;i++){
            System.out.print(left[i] + " ");
        }
        System.out.println();
        for(int i = 0;i < A.length;i++){
            System.out.print(right[i] + " ");
        }
        System.out.println();
        return output;
    }
    public static void main(String[] args){
        int[] test = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(test));
    }
}
