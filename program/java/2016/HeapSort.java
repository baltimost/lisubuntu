public class HeapSort {
    public static void sort(int[] arr) {
        for(int i = arr.length / 2  - 1;i >= 0;i--) {
            heaptify(arr, i, arr.length);
        }
    }
    public static heaptify(int[] arr, int s, int e) {
        int i = s, j = i * 2 + 1;
        while(j < e) {
            if(j + 1 < e && arr[j + 1] > arr[j])
                j++;
            if(arr[i] >= arr[j])
                break;
            swap(arr, i, j);
            i = j;
            j = i * 2 + 1;
        }
    }
    public static swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
