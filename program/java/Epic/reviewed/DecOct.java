import java.util.List;
import java.util.ArrayList;

public class DecOct{
    public static List<Integer> decOctPalindrome(int low, int high){
        List<Integer> output = new ArrayList<Integer>();
        if(low > high) return output;
        for(int i = low;i <= high;i++){
            if(isPalindrome(i) && isPalindrome(decToOct(i)))
                output.add(i);
        }
        return output;
    }
    public static boolean isPalindrome(int number){
        int reverse = 0;
        int tmp = number;
        while(number != 0){
            reverse = reverse * 10 + number % 10;
            number /= 10;
        }
        return reverse == tmp;
    }
    public static int decToOct(int number){
        int output = 0;
        int factor = 1;
        while(number != 0){
            output = output + number % 8 * factor;
            number /= 8;
            factor *= 10;
        }
        return output;
    }
    public static void main(String[] args){
        List<Integer> rst = decOctPalindrome(1,1000);
        for(Integer x : rst)
            System.out.println(x);
    }
}
