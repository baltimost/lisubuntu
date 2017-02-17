public class SortColors {
    public static void sort(int[] arr) {
        int l = 0, h = arr.length - 1, i = 0;
        while(i < h) {
            if(arr[i] == 2 ) {
                swap(arr, i, h);
                h--;
            }
            else if(arr[i] == 0) {
                swap(arr, l, i);
                l++;
                i++;
            }
            else {
                i++;
            }
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
