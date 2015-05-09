public class RemoveDuplicatesfromSortedArray{
    /*TLE
    public static int removeDuplicates(int[] A){
        int output = A.length;
        for(int i = 0;i < output;i++){
            int j = i + 1;
            while(j < output && A[j] == A[i])
                j++;
            int k = i + 1;
            while(j < output)
                A[k++] = A[j++];
            output -= j - k;
        } 
        return output;
    }

    //Too complicated
    public static int removeDuplicates(int[] A){
        int dup = 0;
        for(int i = 0, j = 1;j < A.length;j++){
            if(A[j] == A[i]){
                A[j] = Integer.MIN_VALUE;
                dup ++;
            } else
                i = j;
        }
        int i = 1;
        for(;A[i] != Integer.MIN_VALUE;i++);
        int j = i + 1;
        for(;j < A.length;j++){
            if(A[j] != Integer.MIN_VALUE){
                A[i++] = A[j];
            }
        }
        return A.length - dup;
    }
    */
    public static int removeDuplicates(int[] A){
        if(A == null || A.length == 0)
            return 0;
        int i = 1;
        int j = 1;
        for(;j < A.length;j++) {
            if(A[j] != A[j - 1]) {
                A[i++] = A[j];
            }
        }
        return i; 
    }
    public static void main(String[] args){
        int[] test = {1,1,2,3,4,8,9,9,9,10,10,11,12,39,39,39,39,40,40,40};
        //int len = removeDuplicates(test);
        int len = removeDuplicatesII(test);
        for(int i = 0;i < len;i++)
            System.out.print(test[i] + " ");
        System.out.println();
    } 
}
