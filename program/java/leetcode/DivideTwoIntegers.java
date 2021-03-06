public class DivideTwoIntegers{
    public static int divide(int dividend, int divisor){
        if(divisor == 0)
            return 0;
        if(divisor == 1)
            return dividend;
        if(divisor == -1)
            if(dividend == Integer.MIN_VALUE)
                return Integer.MAX_VALUE;
            else
                return dividend * -1;
        int sign = 1;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
           sign = -1;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        /*
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        */
        int output = 0;
        while(a >= b){
            int shift = 1;
            while(a >= b << shift){
                shift++;
            }
            a -= b << (shift - 1);
            output += 1 << (shift - 1);
        }
        return output * sign;
    }
    public static void main(String[] args){
        System.out.println(divide(2147483647,2));
    }
}
