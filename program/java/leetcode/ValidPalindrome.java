public class ValidPalindrome{
    /*
    public static boolean isPalindrome(String s){
        if(s.equals(""))
            return true;
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            char head = s.charAt(i);
            while(!(head >= '0' && head <= '9') 
                    && !(head >= 'A' && head <= 'Z') 
                    && !(head >= 'a' && head <= 'z')
                    && i != j){
                i++;
                head = s.charAt(i);
            }
            char tail = s.charAt(j);
            while(!(tail >= '0' && tail <= '9') 
                    && !(tail >= 'A' && tail <= 'Z') 
                    && !(tail >= 'a' && tail <= 'z')
                    && i != j){
                j--;
                tail = s.charAt(j);
            }
            head = s.charAt(i);
            tail = s.charAt(j);
            if(head != tail && head - 32 != tail && head + 32 != tail)
                return false;
            i++;
            j--;
        }
        return true;
    }
    */
    public static boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if(!Character.isLetterOrDigit(s.charAt(i)))
                i++;
            else if(!Character.isLetterOrDigit(s.charAt(j)))
                j--;
            else if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String test = "0A man, a plan, a canal: Panama0";
        System.out.println(isPalindrome(test));
    }
}
