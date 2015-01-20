public class SearchForaRange{
    public static int[] searchRange(int[] A, int target){
        int[] output = {-1, -1};
        int mid = binarySearch(A, target, 0, A.length - 1);
        System.out.println(mid);
        if(mid == -1) return output;
        int l = mid;
        int r = mid;
        while(l != - 1){
            output[0] = l;
            l = binarySearch(A, target, 0, l - 1);
        }
        while(r != - 1){
            output[1] = r; 
            r = binarySearch(A, target, r + 1, A.length - 1);
        }
        return output; 
    }
    private static int binarySearch(int[] A, int target, int l, int h){
        if(l < 0 || h >= A.length) return -1;
        while(l <= h){
            int m = (l + h) / 2;
            if(A[m] == target)
                return m;
            else if(A[m] < target)
                l = m + 1;
            else
                h = m - 1;
        }
        return -1;
    }
    public static void main(String[] args){
        //int[] arr = {5,7,7,8,8,10};
        int[] arr = {1,3};
        int[] rst = searchRange(arr, 1);
        System.out.println(rst[0] + "," + rst[1]);
    }
}
