public class JumpGameII{
    public static int jump(int[] A){
        if(A == null || A.length <= 1)
            return 0;
        int output = 1;
        int maxindex = 0;
        int max = 0;
        for(int i = 0;i < A.length;){
            maxindex = i + A[i];
            System.out.println("init maxindex= " + maxindex);
            if(maxindex >= A.length - 1)
                break;
            max = A[i + A[i]];
            /*
            for(int j = 1;j <= A[i];j++){
                System.out.println("--"+(i+j)+" "+ (A[i + j] - A[i] + j));
                if (A[i + j] - A[i] + j > max){
                    maxindex = i + j;
                    max = A[i + j] - A[i] + j;
                }
            } 
            */
            for(int j = i + 1;j <= A[i] + i;j++){
                if(A[j] + j > max){
                    maxindex = j;
                    max = A[j] + j;
                }
            }
            System.out.println("maxindex= " + maxindex);
            i = maxindex;
            output++;
        }
        return output;
    }
    public static void main(String[] args){
        //int[] test = {1,4,1,1,3,3,3,4,1};
        //int[] test = {6,4,1,1,3,3,3,4,1};
        //int[] test = {2,3,0,1,4};
        //int[] test = {5,9,3,2,1,0,2,3,3,1,0,0};
        int[] test = {5,4,0,1,3,6,8,0,9,4,9,1,8,7,4,8};
        System.out.println(jump(test));
    }
}
