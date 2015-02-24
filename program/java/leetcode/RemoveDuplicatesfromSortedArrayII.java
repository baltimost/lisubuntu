public class RemoveDuplicatesfromSortedArrayII{
    public static int removeDuplicates(int[] A){
        if(A == null)
            return 0;
        int i = 1;
        int j = 1;
        int count = 0;
        for(;j < A.length;j++){
            if(A[j] != A[j - 1]){
                A[i++] = A[j]; 
                count = 0;
            }  
            else{
                count++;
                if(count == 1){
                    //A[i] = A[i - 1];
                    A[i] = A[j];
                    i++;
                }
            }
        }
        return i; 
    }
    public static void main(String[] args){
        //int[] test = {1,1,1,2,2,3};
        int[] test = {1,1,1,1,3,3};
        int len = removeDuplicates(test);
        for(int i = 0;i < len;i++)
            System.out.print(test[i] + " ");
        System.out.println();
    }
}

