public class ImplementstrStr{
    public static String strStr(String haystack, String needle){
        if(haystack == null || needle == null)
            return null;
        if(haystack.equals(needle) || needle.equals(""))
            return haystack;

        for(int i = 0;i < haystack.length() - needle.length();i++){
            if(haystack.substring(i,i + needle.length()).equals(needle))
                return haystack.substring(i);
        }
        return null;
            
    }
    public static void main(String[] args){
        String haystack = "";
        String needle = "ocena";
        System.out.println(strStr(haystack, needle));
    }
}
