import java.util.*;

public class Solution {
    public static void heapsort(int[] arr) {
        int n = arr.length;
        for(int i = n / 2 - 1;i >= 0;i--) {
            heaptify(arr, i, n);
        }
        for(int i = n - 1;i >= 1;i--) {
            swap(arr, 0 , i);
            heaptify(arr, 0, i);
        }
    }

    public static void heaptify(int[] arr, int start, int end) {
        for(int i = start, j = i * 2 + 1;j < end;) {
            if(j + 1 < end && arr[j + 1] > arr[j]) {
                j++;
            }
            if(arr[i] >= arr[j]) {
                break;
            }
            swap(arr, i, j);
            i = j;
            j = j * 2 + 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {50, 20, 10, 23, 5, 100, 75};
        //mergesort(arr);
        heapsort(arr);
        for(Integer x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void copy(int[] one, int[] another) {
        for(int i = 0;i < one.length;i++) {
            another[i] = one[i];
        }
    }

}
