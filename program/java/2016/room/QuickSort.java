public class QuickSort {
    public static void sort(int[] arr) {
        partition(arr, 0, arr.length - 1);
    }
    public static void partition(int[] arr, int l, int h) {
        int pivot = arr[l];
        int i = l, j = h;
        while(i < j) {
            while(i < j && arr[j] >= pivot) {
                j--;
            }
            swap(arr, i, j);
            i++;
            while(i < j && arr[i] <= pivot) {
                i++;
            }
            swap(arr, i, j);
            j--;
        }
        partition(arr, l, i - 1);
        partition(arr, i + 1, h);
    }
}
