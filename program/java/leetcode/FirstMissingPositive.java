public class FirstMissingPositive{
    public static int firstMissingPositive(int[] A){
        for(int i = 0;i < A.length;){
            if(A[i] > 0 && A[i] != i + 1 && A[i] - 1 < A.length){
                int tmp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = tmp;
            } else
                i++;
        }
        for(int x: A)
            System.out.print(x + " ");
        System.out.println();
        for(int i = 0;i < A.length;i++)
            if(A[i] !=  i + 1)
                return i + 1;
        return A.length + 1;
    }
    public static void main(String[] args){
        int[] input = {2};
        System.out.println(firstMissingPositive(input));
    }
}
