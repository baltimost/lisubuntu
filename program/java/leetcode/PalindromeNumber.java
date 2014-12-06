public class PalindromeNumber{
    /*
    public static boolean isPalindrome(int x){
        String xstring = Integer.toString(x);
        for(int i = 0;i < xstring.length() - i - 1;i++){
            if(xstring.charAt(i) != xstring.charAt(xstring.length() - i - 1))
                return false;
        }
        return true;
    }
    */
    /*
    */
    public static boolean isPalindrome(int x){
        int denominator = 1;
        int head, tail;
        while(x / denominator >= 10)
            denominator *= 10; 
        
        while(x >= 10){
            head = x / denominator; 
            tail = x % 10;
            if(head != tail)
                return false;
            x = (x % denominator) / 10;
            denominator /= 100;
        }
        return true;
    }//107ms
    /*
    public static boolean isPalindrome(int x){
        int tmp = x;
        int reversed = 0;
        while(tmp > 0){
            reversed = reversed * 10 + tmp % 10;
            tmp /= 10;
        }
        if(reversed == x)
            return true;
        else
            return false;
    }//89ms
    */
    public static void main(String[] args){
        long bf = System.currentTimeMillis();
        long af, interval;
        //System.out.println(isPalindrome(-2147483648));
        System.out.println(isPalindrome(120030221));
        System.out.println(isPalindrome(13100));
        System.out.println(isPalindrome(-12321));
        System.out.println(isPalindrome(1000021));
        for(int i = 0;i < 1000000;i++)
            isPalindrome(381292183);
        af = System.currentTimeMillis();
        interval = af - bf;
        System.out.println(interval);
    }
}
