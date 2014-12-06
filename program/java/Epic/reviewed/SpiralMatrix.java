public class SpiralMatrix{
    public static String spiralTraverse(char[][] matrix){
        StringBuilder output = new StringBuilder();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return output.toString();
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while(true){
            for(int i = left;i <= right;i++)
                output.append(matrix[top][i]);
            top++;
            if(top > bottom)
                break;

            for(int i = top;i <= bottom;i++)
                output.append(matrix[i][right]);
            right--;
            if(left > right)
                break;

            for(int i = right;i >= left;i--)
                output.append(matrix[bottom][i]);
            bottom--;
            if(top > bottom)
                break;

            for(int i = bottom;i >= top;i--)
                output.append(matrix[i][left]);
            left++;
            if(left > right)
                break;
        }
        return output.toString();
    }
    public static void main(String[] args){
        /*
        char[][] input = {
            {'i','l','o','v','e'},
            {'d','i','n','t','e'},
            {'n','e','w','e','p'},
            {'a','i','v','r','i'},
            {'m','a','x','e','c'}
        };
        */
        char[][] input = {
            {'i','l','i','k','e'},
            {'i','-','l','i','z'},
            {'z','u','m','u','h'},
        };
        System.out.println(spiralTraverse(input));
    }
}
