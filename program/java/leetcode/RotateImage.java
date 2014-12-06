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
    public static void main(String[] args){
       int[][] test = {{1,2,3,4},{5,6,7,8,},{9,10,11,12},{13,14,15,16}}; 
       for(int[] x: test){
           for(int y :x){
               System.out.print(y + " ");
           }
           System.out.println();
       }
       rotate(test);
       for(int[] x: test){
           for(int y :x){
               System.out.print(y + " ");
           }
           System.out.println();
       }

    }
}
