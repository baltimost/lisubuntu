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
    public int reverse(int x){
        int output = 0;
        while(x !=  0){
            output = output * 10 + x % 10;
            x /= 10;
        }
        return output;
    }
    public static void main(String[] args){
        //int i = -123;
        int i = 10000021;
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(i));
    }
}
