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
        String haystack = "this is the haystack hoho needle haystack hayhay";
        String needle = "needle";
        System.out.println(strStr(haystack, needle));
    }
}
