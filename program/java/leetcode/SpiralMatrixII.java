public class SpiralMatrixII{
    public static int[][] generateMatrix(int n){
        if(n <= 0)
            return null;
        int[][] output = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int num = 1;
        while(true){
            for(int i = left;i <= right;i++)
               output[top][i] = num++; 
            top++;
            if(top > bottom)
                break;

            for(int i = top;i <= bottom;i++)
                output[i][right] = num++;
            right--;
            if(left > right)
                break;

            for(int i = right;i >= left;i--)
                output[bottom][i] = num++;
            bottom--;
            if(top > bottom)
                break;

            for(int i = bottom;i >= top;i--)
                output[i][left] = num++;
            left++;
            if(left > right)
                break;
        }
        return output;
    }
    public static void main(String[] args){
        int[][] output = generateMatrix(8); 
        for(int[] x: output){
            for(int y: x)
                System.out.print(y + " ");
            System.out.println();
        }
    }
}
