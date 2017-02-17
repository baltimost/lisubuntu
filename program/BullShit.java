public class BullShit {
    public static void quickSort(int[] arr) {
        partition(arr, 0, arr.length - 1);
    }

    public static void partition(int[] arr, int l, int h) {
        if(l >= h) {
            return;
        }
        int pivot = arr[l];
        int i = l, j = h;
        while(i < j) {
            while(i < j && pivot <= arr[j]) {
                j--;
            }
            if(i < j) {
                swap(arr, i, j);
                i++;
            }
            while(i < j && arr[i] <= pivot) {
                i++;
            }
            if(i < j) {
                swap(arr, i, j);
                j--;
            }
        }
        partition(arr, l, i - 1);
        partition(arr, i + 1, h);
    }
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
    public static void main(String[] args) {
        int[] arr = {60, 71, 49, 11, 82, 49, 3, 66};
        quickSort(arr);
        for(int x : arr) {
            System.out.print(x  + " ");
        }
        System.out.println();
    }
    /*
    public static int quickSelect(int[] arr, int n) {
        int l = 0, h = arr.length - 1;
    }
    */
}
