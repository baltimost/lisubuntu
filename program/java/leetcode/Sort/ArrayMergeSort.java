public class ArrayMergeSort{
    /* Array Mergesort
    */
    public static int[] mergeSort(int[] arr){
        int[] tmp = new int[arr.length];
        int flag = 0;
        //for(int sublen = 1;sublen <= arr.length;sublen *= 2){
        for(int sublen = 1;sublen < arr.length;sublen *= 2){
            if(flag % 2 == 0)
                sort(arr, tmp, sublen);
            else
                sort(tmp, arr, sublen);
            flag ++;
        }
        return flag % 2 == 0 ? arr : tmp;
    }
    public static void sort(int[] arr, int[] tmp, int sublen){
        int i = 0;
        while(i < arr.length){
            merge(arr, tmp, 
                    i, 
                    i + sublen < arr.length ? i + sublen : arr.length, 
                    i + 2 * sublen < arr.length ? i + 2 * sublen : arr.length); 
            i += (2 * sublen); 
        }
    }
    public static void merge(int[] arr, int[] tmp, int h, int m, int t){
        int k = h, i = h, j = m;
        while(i < m && j < t){
            tmp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        if(i == m)
            while(j < t)
                tmp[k++] = arr[j++];
        else
            while(i < m)
                tmp[k++] = arr[i++];
    } 
    public static void main(String[] args){
        //int[] test = {60,71,49,11,82,49,3,66,65,-4};
        int[] test = {3,2,4,1,5,6,8,7,4};
        int[] output = mergeSort(test);
        for(int x: output)
            System.out.print(x + " ");
        System.out.println();
    }
}
