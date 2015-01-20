public class MedianofTwoSortedArrays{
    /*Actually no need to merge, just count i and j, when i + j == k return*/
    public static double findMedianSortedArrays(int A[], int B[]){
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
    public static double findMedianSortedArraysAlt(int A[], int B[]){
        int n = A.length;
        int m = B.length;
        if((n + m) % 2 == 0)
            return (findKthElement(A, B, (m + n) / 2) + findKthElement(A, B, (m + n) / 2 + 1)) / 2.0;
        else
            return findKthElement(A, B, (m + n) / 2 + 1);
            
    }
    private static int findKthElement(int A[], int B[], int k){
        int n = A.length;
        int m = B.length;
        int l = 0;
        int h = n - 1;
        int ma;
        int mb;
        while(l <= h){
            ma = (l + h) / 2;
            mb = k - 2 - ma;
            if((mb < 0 || (mb < m && B[mb] <= A[ma])) && (mb + 1 >= m || (mb + 1 >= 0 && A[ma] <= B[mb + 1])))
                return A[ma];
            else if(mb < 0 || (mb + 1 < m && A[ma] > B[mb + 1]))
                h = ma - 1;
            else
                l = ma + 1;
        }
        return findKthElement(B, A, k);
    }

    public static void main(String[] args){
        /*
        int A[] = {1,8,16,30,60};
        int B[] = {3,4,5,6,7,9};
        */
        /*
        int A[] = {1,3,7,9,11};
        int B[] = {2,4,6,8,10,12};
        */
        /*
        int A[] = {1,3,9,11,13};
        int B[] = {2,4,6,8,10,12};
        */
        int A[] = {1,2,3,4,5,6,7,8};
        int B[] = {9};
        System.out.println(findMedianSortedArrays(A,B));
        System.out.println(findMedianSortedArraysAlt(A,B));
        System.out.println(findMedianSortedArraysAlt(B,A));
    }
}
