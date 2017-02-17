public class BinarySearch {
    public static int search(int[] arr, int target) {
        int l = 0, h = arr.length - 1;
        int m;
        while(l <= h) {
            m = (l + h) / 2;
            if(arr[m] == target) 
                return m;
            else if(arr[m] < target)
                l = m + 1;
            else
                h = m - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,11};
        System.out.println(search(arr, 2));
        System.out.println(search(arr, 1));
        System.out.println(search(arr, 11));
        System.out.println(search(arr, 9));
    }
}
