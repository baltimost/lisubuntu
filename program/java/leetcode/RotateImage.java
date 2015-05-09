public class RotateImage{
    public static void rotate(int[][] matrix){
        int[][] output = new int[matrix.length][matrix.length];
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix.length;j++){
                output[j][matrix.length - 1 - i] = matrix[i][j];
            }
        }
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix.length;j++){
                matrix[i][j] = output[i][j];
            }
        }
    }
    public static void rotateBetter(int[][] matrix) {
        if(matrix == null) {
            return;
        }
        //for(int s = 0, e = matrix.length - 1;s < matrix.length / 2;s++, e--) {
        for(int s = 0, e = matrix.length - 1;s < e;s++, e--) {
            for(int i = 0;i < e - s;i++) {
                int tmp = matrix[s][s + i];
                matrix[s][s + i] = matrix[e - i][s];
                matrix[e - i][s] = matrix[e][e - i];
                matrix[e][e - i] = matrix[s + i][e];
                matrix[s + i][e] = tmp;
            }
        }
    }
    public static void main(String[] args){
       int[][] test = {
           {1,2,3,4},
           {5,6,7,8,},
           {9,10,11,12},
           {13,14,15,16}
       }; 
       for(int[] x: test){
           for(int y :x){
               System.out.print(y + " ");
           }
           System.out.println();
       }
       System.out.println();
       rotateBetter(test);
       for(int[] x: test){
           for(int y :x){
               System.out.print(y + " ");
           }
           System.out.println();
       }
    }
}
