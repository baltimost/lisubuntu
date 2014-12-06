public class ValidNumber{
    public static boolean isNumber(String s){
        if(s == null)
            return false;
        s = s.trim();
        if(s.length() == 0)
            return false;
        boolean num = false;
        boolean dot = false;
        boolean exp = false;
        int i = 0;
        if(s.charAt(i) == '+' || s.charAt(i) == '-')
            i++;
        for(;i < s.length();i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                num = true;
            }
            else if(s.charAt(i) == '.'){
                if(dot || exp)
                    return false;
                dot = true;
            }
            else if(s.charAt(i) == 'e'){
                if(exp || !num)
                    return false;
                exp = true;
                num = false;
            }
            else if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                if(s.charAt(i - 1) != 'e')
                    return false;
            }
            else
                return false;
        }
        return num;
    }
    public static void main(String[] args){
        System.out.println(isNumber("0"));
        System.out.println(isNumber(" 0.1"));
        System.out.println(isNumber("abc"));
        System.out.println(isNumber("1 a"));
        System.out.println(isNumber("2e1e0"));
        System.out.println(isNumber("+1.-1"));
    }
}
