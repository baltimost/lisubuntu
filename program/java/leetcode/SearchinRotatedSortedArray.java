public class SearchinRotatedSortedArray{
    /*
    */
    public static int search(int[] A, int target){
        for(int i = 0;i < A.length;i++)
            if(A[i] == target)
                return i;
        return -1;
    }
    /*
    public static int search(int[] A, int target){
        if(A == null || A.length == 0)
            return -1;
        int low = 0;
        int high = A.length - 1;
        int mid = 0;
        while(low <= high){
            mid = (low + high) / 2;
            if(A[mid] == target)
                return mid;
            if(A[mid] >= A[low]){
                if(target < A[mid] && target >= A[low]){
                    high = mid -1;
                } else{
                    low = mid + 1;
                } 
            } else{
                if(target > A[mid] && target <= A[high]){
                    low = mid + 1;
                } else{
                    high = mid - 1;
                }
            } 
            //System.out.println("low: "+low+"mid: "+mid+"high: "+high);
        }
        return -1;
    }
    */
    public static void main(String[] args){
        int[] test = {4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,-200,-100,-90,-20,-7,-8,-5,-3,-2,-1,0,1,2};
        int k = 1000000;
        long bt = System.currentTimeMillis();
        long at, interval;
        while(k-- != 0){
            //search(test,-2);
            for(int i = 0;i < test.length;i++)
                search(test, test[i]);
        }
        at = System.currentTimeMillis();
        interval = at - bt;
        System.out.println(interval);
    }
}
