import java.util.*;
import java.io.*;

public class ReserviorSampling {
    public static int[] samplingK(Scanner s, int k) {  
        int[] res = new int[k];  
        int i = 0;  
        while (i < k) {  
            res[i++] = s.nextInt();  
        }  
        Random r = new Random();  
        while(s.hasNext()) {
            int num = s.nextInt();  
            int rand = r.nextInt(i); // important: inclusive range   
            if(rand < k) {  
                res[rand] = num;  
            }  
        }  
        return res;  
    }  
    public static void main(String[] args) {
        try {
        int[] rst = samplingK(new Scanner(new FileReader("stream.txt")), 5);
        for(int x : rst) {
            System.out.print(x + " ");
        }
        System.out.println();
        } catch(Exception e) {
            ;
        }
    }
}
