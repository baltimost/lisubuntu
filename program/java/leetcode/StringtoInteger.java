public class StringtoInteger{
    public static int atoi(String str){
        if(str == null)
            return 0;
        str = str.trim();
        if(str.length() == 0)
            return 0;
        int sign = 1;
        int index = 0;
        long output = 0;
        if(str.charAt(0) == '+')
            index++;
        if(str.charAt(0) == '-'){
            sign = -1;
            index++;
        }
        for(;index < str.length() 
          && str.charAt(index) >= '0' 
          && str.charAt(index) <= '9'
          && output < Integer.MAX_VALUE
          && output > Integer.MIN_VALUE 
           ;index++){
            output = output * 10 + (str.charAt(index) - '0');
        }
        //System.out.println(output);
        if(output * sign >= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(output * sign <= Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)output * sign;
    }
    public static int atoiAlt(String str) {
        if(str == null || str.length() == 0) return 0;
        int i = 0;
        while(i < str.length() && str.charAt(i) == ' ') i++;
        boolean isNeg = false;
        if(str.charAt(i) == '-' || str.charAt(i) == '+'){
            isNeg = str.charAt(i) == '-';
            i++;
        }
        int output = 0;
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            int digit = str.charAt(i) - '0';
            if(!isNeg && output > (Integer.MAX_VALUE - digit) / 10)
                return Integer.MAX_VALUE;
            else if(isNeg && -output < (Integer.MIN_VALUE + digit) / 10)
                return Integer.MIN_VALUE;
            output = output * 10 + digit;
            i++;
        }
        return isNeg? -output : output;
    }
    public static void main(String[] args){
        //String test = ("  3093h240");
        String test = ("2147483648");
        System.out.println(atoi(test));
        System.out.println(atoi("123"));
        System.out.println(atoiAlt("123"));
        System.out.println(atoi("3093h240"));
        System.out.println(atoiAlt("+123"));
        //System.out.println(atoiAlt(" "));
        int n = 1;
        System.out.println(-n);
    }
}
