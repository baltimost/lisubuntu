public class Searcha2DMatrix{
    public static boolean searchMatrix(int[][] matrix, int target){
        int[] firstrow = new int[matrix.length];
        for(int i = 0;i < matrix.length;i++)
            firstrow[i] = matrix[i][0];
        int line = binarySearch(firstrow, target);
        if(line < 0 || line >= matrix.length)
            return false;
        int row = binarySearch(matrix[line], target); 
        return matrix[line][row] == target;
    }
    public static int binarySearch(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while(low <= high){
            mid = (low + high) / 2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return high;//within a range, in regular binarySearch it should return 0 if target not found
    }
public static boolean searchMatrixAlt(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int l = 0;
        int h = col * row - 1;
        while(l <= h){
            int m = (l + h) / 2;
            int x = m / col;
            int y = m % col;
            System.out.println(matrix[x][y]);
            if(matrix[x][y] < target)
                l = m + 1;
            else if(matrix[x][y] > target)
                h = m - 1;
            else
                return true;
        }
        return false;
    }
    public static void main(String[] args){
        //int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int[][] matrix = {{1,3}};
        System.out.println(searchMatrix(matrix,3));
        System.out.println(searchMatrixAlt(matrix,3));
    }
}
