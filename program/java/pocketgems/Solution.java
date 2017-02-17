public class Solution {
    public static void sort(int[] arr) {
        int l = 0, r = arr.length - 1;
        int i = 0;
        while(l < r) {
            if(arr[i] == 0) {
                swap(arr, l, i); 
                l++;
            }
            else if(arr[i] == 2) {
                swap(aarr, i, r);
                r--;
                i++;
            }
            else {
                i++;
            }
        }
    }
        
}
