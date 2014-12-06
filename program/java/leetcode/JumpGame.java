public class JumpGame{
    public static boolean canJump(int[] A){
        if(A == null)
            return false;
        int i = 0;
        int max = Integer.MIN_VALUE + 1;
        for(;i < A.length;i++){
            max = Math.max(max - 1, A[i]); 
            if(max == 0)
                break;
        }
        return i >= A.length - 1 ? true : false;
    }
    public static void main(String[] args){
        int[] test = {2,3,1,1,4};
        int[] test2 = {3,2,1,0,4};
        System.out.println(canJump(test));
        System.out.println(canJump(test2));
    }
}
