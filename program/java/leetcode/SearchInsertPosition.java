public class SearchInsertPosition{
    public static int searchInsert(int[] A, int target){
        int low = 0;
        int high = A.length - 1;
        int mid;
        while(low <= high){
            mid = (low + high) / 2;
            System.out.println("low = " + low + "high = " + high);
            if(A[mid] == target)
                return mid;
            else if(A[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
    public static void main(String[] args){
        int[] test = {1}; 
        System.out.println(searchInsert(test, 2));

    }
}
