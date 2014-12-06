public class DivideTwoIntegers{
    public static int divide(int dividend, int divisor){
        if(divisor == 0)
            return 0;
        int sign = 1;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
           sign = -1;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int output = 0;
        while(a >= b){
            int shift = 0;
            while(a >= b << shift){
                shift++;
            }
            a -= b << (shift - 1);
            output += 1 << (shift - 1);
        }
        return output * sign;
    }
    public static void main(String[] args){
        System.out.println(divide(2,0));
    }
}
