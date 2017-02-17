public class QuickSelect{
    public static int quickselect(int[] arr, int k){
        if(k > arr.length || k < 0) return -1;
        k--;
        int l = 0, h = arr.length - 1;
        while(l <= h){
            int m = partition(arr, l, h);
            if(m == k)
                return arr[m];
            else if(m < k)
                l = m + 1;
            else
                h = m - 1;
        }
        return -1;
    }
    private static int partition(int[] arr, int l, int h){
        int i = l, j = h;
        int pivot = arr[i];
        while(i < j){
            while(arr[j] >= pivot && i < j)
                j--;
            if(i < j){
                swap(arr, i, j);
                i++;
            }
            while(arr[i] <= pivot && i < j)
                i++;
            if(i < j){
                swap(arr, i, j);
                j--;
            }
        }
        return i;
    }
    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args){
        //int[] arr = {10,20,30,40,50,60,70,80};
        int[] arr = {40, 60, 20, 10, 30, 50, 80, 70};
        System.out.println(quickselect(arr, 1));
        for(int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
