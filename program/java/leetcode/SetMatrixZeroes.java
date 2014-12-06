public class SetMatrixZeroes{
    /*
    public static void setZeroes(int[][] matrix){
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    for(int k = 0;k < matrix[0].length;k++){
                        if(matrix[i][k] != 0)
                            matrix[i][k] = Integer.MIN_VALUE;
                    }
                    for(int k = 0;k < matrix.length;k++){
                        if(matrix[k][j] != 0)
                            matrix[k][j] = Integer.MIN_VALUE;
                    }
                }
            }
        }
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++)
                if(matrix[i][j] == Integer.MIN_VALUE)
                    matrix[i][j] = 0;
        }
    }
    */
    public static void setZeroes(int[][] matrix){
        if(matrix == null)
            return;
        boolean firstline = false;
        boolean firstrow = false;
        if(matrix[0][0] == 0){
            firstline = true;
            firstrow = true;
        }
        //record firsline firstrow
        for(int i = 0;i < matrix[0].length;i++)
            if(matrix[0][i] == 0){
                firstline = true;
                break;
            }
        for(int i = 0;i < matrix.length;i++)
            if(matrix[i][0] == 0){
                firstrow = true;
                break;
            }

        //record following lines rows into firstline and firstrow
        for(int i = 1;i < matrix.length;i++){
            for(int j = 1;j < matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        //set following lines according to the aformentioned record
        for(int i = 1;i < matrix.length;i++){
            for(int j = 1;j < matrix[0].length;j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }
        //set firstline firstrow
        if(firstline)
            for(int i = 0;i < matrix[0].length;i++)
                matrix[0][i] = 0;
        if(firstrow)
            for(int i = 0;i < matrix.length;i++)
                matrix[i][0] = 0;
    }
    public static void main(String[] args){
        int[][] matrix = {{1,2,0,4,0,6},{7,0,9,10,11,12},{3,1,3,4,3,8}};
        for(int[] x: matrix){
            for(int y: x)
                System.out.print(y + "      ");
            System.out.println();
        }
        System.out.println();
        setZeroes(matrix);

        for(int[] x: matrix){
            for(int y: x)
                System.out.print(y + "      ");
            System.out.println();
        }
    }
}
