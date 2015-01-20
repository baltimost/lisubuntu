import java.util.*;

public class ReverseInteger{
    /* What a crap!!!!!
    public int reverse(int x){
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(0);
        for(int i = 0, d = 10;;i++){
            if(x/d != 0)
                al.add(x % d - al.get(i));
            else{
                al.add(x);
                break;
            }
            d *= 10;
        }
         
        int digit = 1, output = 0;
        for(int i = 1;i < al.size();i++){
            al.set(i,al.get(i)/digit);
            digit *= 10;
        }
        digit /= 10;
        for(int i = 1;i < al.size();i++){
            output += (al.get(i) * digit);
            digit /= 10;
        }
        return output;
    }
    */
    public static int reverse(int x){
        int output = 0;
        boolean isNeg = x < 0;
        while(x !=  0){
            if(!isNeg && output > (Integer.MAX_VALUE - x % 10) / 10 ||
            isNeg && output < (Integer.MIN_VALUE - x % 10) / 10)
                return 0; 
            output = output * 10 + x % 10;
            x /= 10;
        }
        return output;
    }
    public static void main(String[] args){
        //int i = -123;
        int i = 10000021;
        System.out.println(reverse(i));
        i = 100;
        System.out.println(reverse(i));
        i = 1000000003;
        System.out.println(reverse(i));
        i = 1534236469;
        System.out.println(reverse(i));
        i = -123;
        System.out.println(reverse(i));
    }
}
