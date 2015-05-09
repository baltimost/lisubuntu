public class FirstMissingPositive{
    public static int firstMissingPositive(int[] A){
        for(int i = 0;i < A.length;){
            if(A[i] > 0 && A[i] != i + 1 && A[i] - 1 < A.length && A[A[i] - 1] != A[i]){
                int tmp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = tmp;
            } else
                i++;
        }
        /*
        for(int x: A)
            System.out.print(x + " ");
        System.out.println();
        */
        for(int i = 0;i < A.length;i++)
            if(A[i] !=  i + 1)
                return i + 1;
        return A.length + 1;
    }
    public static int firstMissingPositiveAlt(int[] A){
        if(A == null || A.length == 0) return 1;
        for(int i = 0;i < A.length;){
            if(A[i] < 0 || A[i] >= A.length || /*A[i] == i || */A[i] == A[A[i]])
                i++;
            else
                Tools.swap(A, i, A[i]);
        }
        for(int i = 1;i < A.length;i++)
            if(A[i] != i)
                return i;
        return A[0] == A.length ? A.length + 1 : A.length;
    }
public static int firstMissingPositiveWrong(int[] A){
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < A.length;i++){
            if(A[i] > 0){
                sum += A[i];
                min = Math.min(min, A[i]);
                max = Math.max(max, A[i]);
            }
        }
        if(min != 1) return 1;
        if(sum != supposeSum(min, max)) 
            return supposeSum(min, max) - sum;
        else if(min == 1)
            return max + 1;
        else
            return min - 1;
    }
    private static int supposeSum(int min, int max){
        if(max - min % 2 == 0){
            int mid = (min + max) / 2;
            return mid + (min + max) * ((max - min) / 2);
        }
        else
            return (min + max) * ((max - min) / 2 + 1);
    }
    public static void main(String[] args){
        //int[] input = {100};
        int[] input = {6,4,5,1,2};
        //int[] input = {3,5,-1,1};
        //int[] input = {2,4,3,1};
        //int[] input = {1,1};
        System.out.println(firstMissingPositive(input));
        System.out.println(firstMissingPositiveAlt(input));
        //System.out.println(firstMissingPositiveWrong(input));
    }
}
