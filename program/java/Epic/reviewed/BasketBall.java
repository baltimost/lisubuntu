import java.io.*;

public class BasketBall{
    public static double getHit(int h, int c, int r){
        if(r <= 0 || r >= 162){
            System.out.println("There's no way");
            return -1.0;
        }
        double output = 0.45 * (c + r * 4.5) - h;
        if(output > r * 4.5){
            System.out.println("There's no way");
            return -1.0;
        }
        return output;
    }
    public static void main(String[] args){
        BufferedReader strin = new BufferedReader(
                new InputStreamReader(System.in));
        String h = null;
        String c = null;
        String r = null;
        try{
            System.out.println("h");
            h = strin.readLine();
            System.out.println("c");
            c = strin.readLine();
            System.out.println("r");
            r = strin.readLine();
        } catch(Exception e){
            ;
        }
        System.out.println(getHit(Integer.parseInt(h),Integer.parseInt(c),Integer.parseInt(r)));
    }
}
