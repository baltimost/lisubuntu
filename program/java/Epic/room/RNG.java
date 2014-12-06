import java.util.Calendar;
import java.util.Random;
public class RNG{
    //public static int seed = 123; 
    public static int a = 16645;
    public static int c = 10139;
    public static int m = 32768;
    public static int genRandom(int range){
        Calendar calendar = Calendar.getInstance();
        int seed = Math.abs((int)calendar.getTimeInMillis() % 1000);
        seed = (a * seed + c) % m;
        return seed % range;
    }
    public static void main(String[] args){
        char[][] matrix = new char[10][10];
        for(int i = 0;i < 500;i++){
            int index = genRandom(100);
            int x = index % 10;
            int y = index / 10;
            matrix[x][y] = '*';
            try{Thread.sleep(100);}catch(Exception e){;}
            for(char[] xx : matrix){
                for(char yy : xx){
                    if(yy == '*') System.out.print("* ");
                    else System.out.print("_ ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
