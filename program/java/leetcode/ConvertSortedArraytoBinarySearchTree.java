import java.util.*;

public class ConvertSortedArraytoBinarySearchTree{
    public boolean is ValidNumber(String number) {
        boolean num, sig, exp, dot;
        for(int i = 0;i < number.length();i++) {
            char cur = number.charAt(i);
            if(cur >= '0' && cur <= '9) {
                num = true;
            }
            else if(cur == '-' || cur == '+') {
                if(sig || dot || num) {
                    return false;
                }
                sig = true;
            }
            else if(cur == '.') {
                if(dot || exp) {
                    return false;
                }
                dot = true;
            }
            else if(cur == 'e') {
                if(exp || !num) {
                    return false;
                }
                exp = true;
                sig = false;
                num = false;
                dot = false;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
