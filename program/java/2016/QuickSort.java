public class QuickSort {
    public static void sort(int[] arr) {
        partition(arr, 0, arr.length - 1);
    } 
    public static void partition(int[] arr, int l, int h) {
        if(l >= h)
            return;
        int i = l, j = h, pivot = arr[l];
        while(i < j) {
            while(i < j && pivot <= arr[j]) {
                j--;
            }
            if(i < j) {
                swap(arr, i, j);
                i++;
            }
            while(i < j && pivot >= arr[i]) {
                i++;
            }
            if(i < j) {
                swap(arr, i, j);
                j--;
            }
        }
        System.out.println("j:"+j+" i:" + i);
        partition(arr, l, i - 1);
        partition(arr, i + 1, h);
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
    public static void main(String[] args) {
        int[] arr = {60, 71, 49,11, 82 , 49, 3, 66};
        for(int x : arr)
            System.out.print(x + " ");
        System.out.println();
        sort(arr);
        for(int x : arr)
            System.out.print(x + " ");
        System.out.println();
    }
}
