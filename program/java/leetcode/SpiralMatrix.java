import java.util.*;

public class SpiralMatrix{
    public static List<Integer> spiralOrder(int[][] matrix){
        if(matrix == null)
            return null;
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        List<Integer> output = new ArrayList<Integer>();
        //while(top <= bottom && left <= right){
        while(true){
            System.out.println("top="+top+" bottom="+bottom+" left"+left+" right"+right);
            for(int i = left;i <= right;i++)
                output.add(matrix[top][i]);
            top++;
            if(top > bottom)
                break;

            for(int i = top;i <= bottom;i++)
                output.add(matrix[i][right]);
            right--;
            if(left > right)
                break;

            for(int i = right;i >= left;i--)
                output.add(matrix[bottom][i]);
            bottom--;
            if(top > bottom)
                break;

            for(int i = bottom;i >= top;i--)
                output.add(matrix[i][left]);
            left++;
            if(left > right)
                break;
        }
        return output;
    }
    public static void main(String[] args){
        //int[][] matrix = {{1,2,3},{4,5,6,},{7,8,9}};
        int[][] matrix = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        //int[][] matrix = {{2,3,4,5}};
        for(int[] x: matrix){
            for(int y: x)
                System.out.print(y + " ");
            System.out.println();
        }
        List<Integer> output = spiralOrder(matrix);
        for(Integer x: output)
            System.out.print(x + " ");
        System.out.println();
    }
}
