import java.util.List;
import java.util.ArrayList;

public class EquationNumber{
    public static boolean isEquationNumber(int number){
        List<Integer> entry = new ArrayList<Integer>();
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        separate(number, entry, output);
        for(List<Integer> x : output){
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for(Integer y : x){
                System.out.print(y + " ");
                max = Math.max(max, y);
                sum += y;
            }
            System.out.println();
            if(max * 2 == sum)
                return true;
        }
        return false;
    }
    public static void separate(int number, List<Integer> entry, List<List<Integer>> output){
        //if(entry.size() == 2){
            entry.add(number);
            output.add(new ArrayList<Integer>(entry));
            entry.remove(entry.size() - 1);
            //return;
        //}
        for(int i = 10;number / i != 0;i *= 10){
            entry.add(number % i);
            separate(number / i, entry, output);
            entry.remove(entry.size() - 1);
        }
    }
    public static void main(String[] args){
        System.out.println(isEquationNumber(1236));
    }
}
