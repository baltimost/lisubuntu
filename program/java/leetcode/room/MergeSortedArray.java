public class MergeSortedArray{
    /*Wrong answer, what if n < m? 2*m may bigger than A.length
    public static void merge(int A[], int m, int B[], int n){
        for(int i = 0;i < m;i++)
            A[m + i] = A[i];
        int i = m;
        int j = 0;
        int k = 0;
        while(i < 2 * m && j < n){
            if(A[i] <= B[j])
                A[k++] = A[i++];
            else
                A[k++] = B[j++];
        }
        if(i == 2 * m)
            while(j < n)
                A[k++] = B[j++];
        else
            while(i < 2 * m)
                A[k++] = A[i++];
    }
    */
    /*There's a better answer
    public static void merge(int A[], int m, int B[], int n){
        int i = 0;
        int j = 0;
        int Alen = m;
        while(m > 0 && j < n){
            if(A[i] > B[j]){
                for(int k = 0;Alen - k > i;k++){
                    A[Alen - k] = A[Alen - k - 1];
                    System.out.println("m - k:" + (Alen - k));
                }
                Alen++;
                A[i++] = B[j++];
            }else{
                i++;
                m--;
            }

            for(int x: A)
                System.out.print(x + " ");
            System.out.println();
        }
        if(m == 0)
            while(j < n)
                A[i++] = B[j++];
    }
    */
    public static void merge(int A[], int m, int B[], int n){
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while(i >= 0 && j >= 0){
            if(A[i] >= B[j])
                A[k--] = A[i--];
            else
                A[k--] = B[j--];
        }
        if(i < 0)
            while(j >= 0)
                A[k--] = B[j--];
    }
    public static void main(String[] args){
        int[] A = {11,49,60,71,0,0,0,0,0,0,0,0,0};
        int[] B = {3,49,66,82};
        for(int x: A)
            System.out.print(x + " ");
        System.out.println();
        merge(A, 4, B, 4);
        for(int x: A)
            System.out.print(x + " ");
        System.out.println();
    }
}
