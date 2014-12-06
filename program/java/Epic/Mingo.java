import java.util.Random;

public class Mingo{
    public static void findMingo(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        if(n == 0 || m == 0 || n != m)
            return;
        int[] random = new int[n * n];
        int[] row = new int[n];
        int[] col = new int[n];
        int diagonal1 = 0;
        int diagonal2 = 0;
        Random r = new Random();
        int max = n * n;
        int count = 0;
        for(int i = 0;i < n * n;i++)
            random[i] = i;

        for(int i = 0;i < n * n;i++){
            int index = r.nextInt(max); 
            int position = random[index]; 
            random[index] = random[max - 1];
            max--;
            int x = position / n;
            int y = position % n;
            matrix[x][y] = r.nextInt(1000);
            row[x]++;
            col[y]++;

            printMatrix(matrix);
            try{Thread.sleep(300);}catch(Exception e){;}


            if(x == y){
                diagonal1++;
                if(diagonal1 == n){
                    count++;
                    System.out.println("Mingo:" + count + " diagonal1");
                    try{Thread.sleep(4000);}catch(Exception e){;}
                }
            }
            if(x + y == n - 1){
                diagonal2++;
                if(diagonal2 == n){
                    count++;
                    System.out.println("Mingo:" + count + " diagonal2");
                    try{Thread.sleep(4000);}catch(Exception e){;}
                }
            }
        
            if(row[x] == n){
                count++;
                System.out.println("Mingo:" + count + " row:" + x);
                    try{Thread.sleep(4000);}catch(Exception e){;}
            }
            if(col[y] == n){
                count++;
                System.out.println("Mingo:" + count + " col:" + y);
                    try{Thread.sleep(4000);}catch(Exception e){;}
            }
        }
    }
    public static void main(String[] args){
        int n = 10;
        int[][] input = new int[n][n];
        findMingo(input);
    }
    private static void printMatrix(int[][] matrix){
        for(int[] x : matrix){
            for(int y : x){
                int len = String.valueOf(y).length();
                System.out.print(y);
                for(int i = 0;i < 5 - len;i++)
                    System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
