import java.util.List;
import java.util.ArrayList;

public class AdditiveNum{
    public static List<Integer> findAdditiveNum(int start, int end){
        List<Integer> output = new ArrayList<Integer>();
        int entry = 0;
        int max = getMax(getDigitNum(end), end);
        for(int i = 1;i <= max;i++){
            int add1 = i, add2 = i;
            entry = add1 * (int)Math.pow(10, getDigitNum(add1)) + add2;
            while(entry <= end){
                if(entry >= start) output.add(entry);
                int sum = add1 + add2;
                entry = entry * (int)Math.pow(10, getDigitNum(sum)) + sum;
                if(sum < 0 || entry < 0) break;
                add1 = add2;
                add2 = sum;
            }
        }
        return output;
    }
    public static int getMax(int digitNum, int end){
        if(digitNum / 2 != 0){
            return (int)Math.pow(10, digitNum / 2 + 1) - 1;
        }
        return end / (int)Math.pow(10, digitNum / 2);
    }
    public static int getDigitNum(int number){
        for(int i = 1 ;;i++){
            if(number / 10 < 1)
                return i;
            number /= 10;
        }
    }
    public static void main(String[] args){
        //List<Integer> rst = findAdditiveNum(1, 7000000);
        List<Integer> rst = findAdditiveNum(800000, 7000000);
        for(Integer x : rst)
            System.out.println(x);
    }
}
