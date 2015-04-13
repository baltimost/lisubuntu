public class JumpGameII{
    public static int jump(int[] A){
        if(A == null || A.length <= 1)
            return 0;
        int output = 1;
        int maxindex = 0;
        int max = 0;
        for(int i = 0;i < A.length;){
            maxindex = i + A[i];
            if(maxindex >= A.length - 1)
                break;
            //max = A[i + A[i]];
            max = 0; 
            for(int j = i + 1;j <= A[i] + i;j++){
                if(A[j] + j > max){
                    maxindex = j;
                    max = A[j] + j;
                }
            }
            i = maxindex;
//            System.out.println("A["+maxindex+"]="+A[maxindex]);
            output++;
        }
        return output;
    }
    public static void main(String[] args){
        int[] test1 = {1,4,1,1,3,3,3,4,1};
        System.out.println(jump(test1));
        int[] test2 = {6,4,1,1,3,3,3,4,1};
        System.out.println(jump(test2));
        int[] test3 = {2,3,0,1,4};
        System.out.println(jump(test3));
        int[] test4 = {5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(jump(test4));
        int[] test5 = {5,4,0,1,3,6,8,0,9,4,9,1,8,7,4,8};
        System.out.println(jump(test5));

        int[] test6 = {2,3,1,2,0,4};
        System.out.println(jump(test6));
        int[] test7 = {2,3,1,1,4};
        System.out.println(jump(test7));
    }
}
