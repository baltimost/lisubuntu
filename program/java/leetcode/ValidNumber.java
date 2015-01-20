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
    public static boolean isNumberAlt(String s) {
        if(s == null || s.length() == 0) return false;
        boolean num = false;
        boolean exp = false;
        boolean dec = false;
        boolean sig = false;
        int i = 0;
        while(i < s.length() && s.charAt(i) == ' ') i++;
        while(i < s.length()){
            char curr = s.charAt(i);
            if(curr >= '0' && curr <= '9')
                num = true;
            else if(curr == '-' || curr == '+'){
                if(sig || dec || num) 
                    return false;
                else 
                    sig = true;
            }
            else if(curr == '.'){
                if(dec || exp) 
                    return false;
                else 
                    dec = true;
            }
            else if(curr == 'e'){
                if(exp || !num) 
                    return false;
                else{
                    exp = true;
                    sig = false;
                    num = false;
                    dec = false;//not for exp itself, but for the judgement of sig 
                }
            }
            else if(curr == ' ')
                break;
            else
                return false;
            i++;
        }
        while(i < s.length()){
            if(s.charAt(i) != ' ') return false;
            i++;
        }
        return num;
    }
    public static void main(String[] args){
        System.out.println(isNumber("32.e-80123"));
        System.out.println(isNumberAlt("32.e-80123"));
    }
}
