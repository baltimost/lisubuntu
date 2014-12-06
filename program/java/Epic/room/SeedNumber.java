import java.util.ArrayList;

public class SeedNumber{
    public static List<Integer> seedNumber(int number){
        List<Integer> output = new ArrayList<Integer>();
        int min = (int)Math.sqrt(number);
        int max = number / 2;
        if(isValid(number, number))
            output.add(number);
        for(int i = min;i <= max;i++){
            if(number % i == 0 && isValid(i, number))
                output.add(i);
        }
        return output;
    }
    public static boolean isValid(int factor, int number){
        System.out.print(factor + " ");
        int product = factor;
        while(factor != 0){
            product *= factor % 10;
            factor /= 10;
        }
        return product == number;
    }
    public static void main(String[] args){
        //List<Integer> rst = seedNumber(2224);
        //List<Integer> rst = seedNumber(1716);
        List<Integer> rst = seedNumber(3339);
        System.out.println("\n==");
        for(Integer x : rst)
            System.out.println(x);
    }
}

