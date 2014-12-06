public class ValidPassword{
    public static boolean isValid(String entered, String expected){
        Character brokenkey = null;
        int i, j;
        for(i = 0, j = 0;i < entered.length() && j < expected.length();j++){
            if(brokenkey != null && entered.charAt(i) == brokenkey) return false;
            if(entered.charAt(i) != expected.charAt(j)){
                if(brokenkey != null && brokenkey != expected.charAt(j))
                    return false;
                else
                    brokenkey = expected.charAt(j);
            }
            else
                i++;
        }
        if(i != entered.length()) return false;
        for(;j < expected.length();j++)
            if(expected.charAt(j) != brokenkey)
                return false;
        return true;
    }
    public static void main(String[] args){
        System.out.println(isValid("164", "18684"));
        System.out.println(isValid("164", "186848"));
        System.out.println(isValid("164", "1868487"));
        System.out.println(isValid("1644", "18684"));
        System.out.println(isValid("1648", "18684"));
        System.out.println(isValid("1246", "12646"));
    }
}
