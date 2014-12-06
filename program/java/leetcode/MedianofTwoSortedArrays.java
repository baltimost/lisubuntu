public class MedianofTwoSortedArrays{
    public double findMedianSortedArrays(int A[], int B[]){
        int C[] = new int[A.length + B.length];
        int k = 0;
        int i = 0;
        int j = 0;
        double output=0;
        for(;i<A.length&&j<B.length;k++){
            if(A[i]<B[j]){
                C[k] = A[i];
                i++;
            }
            else{
                C[k] = B[j];
                j++;
            }
        }
        if(i==A.length)
            for(int x=k;x<C.length;x++,j++)
                C[x] = B[j];
        else
            for(int x=k;x<C.length;x++,i++)
                C[x] = A[i];
        if(C.length%2 == 0)
            output = ((double)C[C.length/2] + (double)C[C.length/2-1])/2;
        else
            output = C[C.length/2];
        return output;
    }

    public static void main(String[] args){
        MedianofTwoSortedArrays mtsa = new MedianofTwoSortedArrays();
        int A[] = {1,8,16,30,60,100};
        int B[] = {3,4,5,6,7,9};
        double result = mtsa.findMedianSortedArrays(A,B);
        System.out.println(result);
    }
}
