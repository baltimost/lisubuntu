public class BinarySearch{
    public static int binarysearch(int[] arr, int target){
        int l = 0, h = arr.length - 1;
        int m;
        while(l <= h){
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
    //recursively
    public static int binarysearchAlt(int[] arr, int target){
        return helper(arr, target, 0, arr.length - 1);
    }
    private static int helper(int[] arr, int target, int l, int h){
        if(l > h) return -1;
        int m = (l + h) / 2;
        if(arr[m] == target)
            return m;
        else if(arr[m] < target)
            return helper(arr, target, m + 1, h);
        else
            return helper(arr, target, l, m - 1);
    }
    public static void main(String[] args){
        int[] arr = {1,3,6,8,11,13,34,41,69};
        System.out.println(binarysearch(arr, 6));
        System.out.println(binarysearch(arr, 69));
        System.out.println(binarysearch(arr, 1));
        System.out.println(binarysearch(arr, 10));

        System.out.println(binarysearchAlt(arr, 6));
        System.out.println(binarysearchAlt(arr, 69));
        System.out.println(binarysearchAlt(arr, 1));
        System.out.println(binarysearchAlt(arr, 10));
    }
}
