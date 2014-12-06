import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class ColorfulNumber{
    public static boolean isColorfulNumber(int number){
        List<Integer> digits = getDigits(number);
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i = 0;i < digits.size();i++){
            if(hs.contains(digits.get(i))) 
                return false;
            hs.add(digits.get(i));
            int product = digits.get(i);
            for(int j = i + 1;j < digits.size();j++){
                product *= digits.get(j); 
                if(hs.contains(product))
                    return false;
                hs.add(product);
            }
        }
        return true;
    }
    public static List<Integer> getDigits(int number){
        List<Integer> digits = new ArrayList<Integer>();
        while(number != 0){
            digits.add(number % 10);
            number /= 10;
        }
        return digits;
    }
    public static void main(String[] args){
        System.out.println(isColorfulNumber(261));
        System.out.println(isColorfulNumber(260));
        System.out.println(isColorfulNumber(263));
        System.out.println(isColorfulNumber(2634));
        System.out.println(isColorfulNumber(2364));
        System.out.println(isColorfulNumber(6742));
    }
}
