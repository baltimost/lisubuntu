public class SaddlePoint{
    public static int[] findSaddlePoint(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int[] rowMax = new int[n];
        int[] colMin = new int[m];
        int[] output = {-1,-1}; 
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(matrix[i][j] > matrix[i][rowMax[i]])
                    rowMax[i] = j;
                if(matrix[i][j] < matrix[colMin[j]][j])
                    colMin[j] = i;
            }
        }
        for(int i = 0;i < n;i++){
            if(colMin[rowMax[i]] == i){
                output[0] = i;
                output[1] = rowMax[i];
                return output;
            }
        }
        return output;
    }
    public static void main(String[] args){
        int[][] input = {
            {7,6,5,8},
            {3,2,4,1},
            {10,11,12,9}};
        int[] rst = findSaddlePoint(input);
        System.out.println(input[rst[0]][rst[1]]);
    }
}
