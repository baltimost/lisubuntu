import java.util.Stack;

public class MaximalRectangle{
    /*Wrong Answer what if 111
                           001
                           111
    public static int maximalRectangle(char[][] matrix){
        int[][][] d = new int[matrix.length][matrix[0].length][2];
        int output = 0;
        if(matrix[0][0] == '1'){
            d[0][0][0] = 1;
            d[0][0][1] = 1;
        }
        for(int i = 1;i < matrix[0].length;i++){
            if(matrix[0][i] == '1'){
                d[0][i][0] = d[0][i - 1][0] + 1;
                d[0][i][1] = 1;
                output = Math.max(output, d[0][i][0] * d[0][i][1]);
            }
        }
        for(int i = 1;i < matrix.length;i++){
            if(matrix[i][0] == '1'){
                d[i][0][0] = 1;
                d[i][0][1] = d[i - 1][0][1] + 1;
                output = Math.max(output, d[i][0][0] * d[i][0][1]);
            }
        }
        for(int i = 1;i < matrix.length;i++){
            for(int j = 1;j < matrix[0].length;j++){
                if(matrix[i][j] == '1'){
                    d[i][j][0] = d[i][j - 1][0] + 1;
                    d[i][j][1] = d[i - 1][j][1] + 1;
                    output = Math.max(output, d[i][j][0] * d[i][j][1]);
                }
            }
        }
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                System.out.print(d[i][j][0] + "," + d[i][j][1] + " ");
            }
            System.out.println();
        }
        return output;
    }
    */
    public static int maximalRectangle(char[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int output = 0;
        int[] height = new int[matrix[0].length];
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                height[j] = matrix[i][j] == '1' ? height[j] + 1: 0;
            }
            for(int x: height)
                System.out.print(x + " ");
            System.out.println();
            System.out.println(largestRectangle(height));
            output = Math.max(output, largestRectangle(height));
        }
        return output;
    }
    private static int largestRectangle(int[] height){
        if(height == null || height.length == 0)
            return 0;
        Stack<Integer> st = new Stack<Integer>();
        int output = 0;
        st.push(0);
        for(int i = 1;i < height.length + 1;i++){
            int curH = i == height.length ? - 1: height[i];
            while(!st.isEmpty() && curH <= height[st.peek()]){
                int h = height[st.pop()];
                int w = st.isEmpty() ? i : i - st.peek() - 1;
                output = Math.max(output, w * h);
            }
            st.push(i);
        }
        return output;
    }
    public static void main(String[] args){
        /*
            */
        char[][] test = {
            {'0','1','1','0','1'},
            {'1','1','0','1','0'},
            {'0','1','1','1','0'},
            {'1','1','1','1','0'},
            {'1','1','1','1','1'},
            {'0','0','0','0','0'}};
        /*
        char[][] test = {
            {'0','0','0','0','0','0','0'},
            {'1','1','1','1','1','1','1'},
            {'0','1','1','0','0','0','0'},
            {'0','1','1','0','0','0','0'},
            {'0','1','0','0','0','1','0'},
            {'0','1','1','0','0','0','0'}};
            */
        //char[][] test = {{'1'},{'1'}};
        System.out.println(maximalRectangle(test));
    }
}
