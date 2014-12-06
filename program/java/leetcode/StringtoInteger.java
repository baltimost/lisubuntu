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
        if(output * sign >= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(output * sign <= Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)output * sign;
    }
    public static void main(String[] args){
        //String test = ("  3093h240");
        String test = ("2147483648");
        System.out.println(atoi(test));
    }
}
