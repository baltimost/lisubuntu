import java.util.*;

public class GrayCode{
    public static List<Integer> grayCode(int n){
        if(n <= 0)
            return null;
        ArrayList<Integer> output = new ArrayList<Integer>();
        output.add(0);
        output.add(1);

        /*
        for(int i = 1;i < n;i++){
            for(int j = (int)Math.pow(2,i) - 1;j >= 0;j--)
                output.add(output.get(j) + (int)Math.pow(2,i));
        }//grayCode(20) 430ms
        */
        for(int i = 1;i < n;i++){
            for(int j = (1 << i) - 1;j >= 0;j--)
                output.add(output.get(j) + (1 << i));
        }//grayCode(20) 165ms
        /*
        for(Integer x: output)
            System.out.print(x + " ");
        System.out.println();
        */
        return output;
    }
    public static void main(String[] args){
        long bt = System.currentTimeMillis();
        long at;
        long interval;
        grayCode(20);
        at = System.currentTimeMillis();
        interval = at - bt;
        System.out.println("Time: " + interval);

    } 
}
