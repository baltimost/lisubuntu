import java.util.List;
import java.util.ArrayList;

public class GenPrime{
    public static List<Integer> genPrime(int N){
        List<Integer> output = new ArrayList<Integer>();
        output.add(2);
        for(int i = 3;i <= N;i += 2){
            int j;
            for(j = 2;j <= Math.sqrt(i);j++)
                if(i % j == 0) break;
            if(j > Math.sqrt(i))
                output.add(i);
        }
        return output;
    }
    public static void main(String[] args){
        List<Integer> rst = genPrime(100);
        for(Integer x : rst)
            System.out.print(x + " ");
        System.out.println();
    }
}
