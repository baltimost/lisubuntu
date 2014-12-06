public class SearchforaRange{
    /*
    public static int[] searchRange(int[] A, int target){
        int[] output = {-1, -1};
        int low = 0;
        int high = A.length - 1;
        int mid = 0;
        while(low <= high){
            mid = (low + high) / 2;
            if(A[mid] == target)
                break;
            else if(A[mid] > target)
                high = mid - 1;
            else 
                low = mid + 1;
        }
        System.out.println(A[mid]);
        if(A[mid] != target)
            return output; 
        int i;
        for(i = mid + 1;i < A.length && A[i] == target;i++);
        output[1] = i - 1;
        for(i = mid - 1;i >= 0 && A[i] == target;i--);
        output[0] = i + 1;
        return output;
    }
    */
    public static int[] searchRange(int[] A, int target){
        int[] output = {-1, -1};
        int mid = binarySearch(A, 0, A.length - 1, target);
        if(mid == -1)
            return output; 
        output[0] = mid;
        output[1] = mid;
        int lmid = mid;
        int rmid = mid;
        while(lmid != 0){
            lmid = binarySearch(A, 0, lmid - 1, target);                            
            if(lmid == - 1)
                break;
            output[0] = Math.min(output[0], lmid);
        }
        while(rmid != A.length - 1){
            rmid = binarySearch(A, rmid + 1, A.length - 1, target);
            if(rmid == -1)
                break;
            output[1] = Math.max(output[0], rmid);
        }
        return output;
    }
    public static int binarySearch(int[] A, int low, int high, int target){
        int mid;
        while(low <= high){
            mid = (low + high) / 2;
            if(A[mid] == target)
                return mid;
            else if(A[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] test = {5,7,7,8,8,10};
        //int[] test = {1,2,3};
        int[] rst = searchRange(test, 7);
        System.out.println(rst[0]);
        System.out.println(rst[1]);
    }
}
