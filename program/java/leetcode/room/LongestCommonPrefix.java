public class LongestCommonPrefix{
    public static String longestCommonPrefix(String[] strs){
        if(strs == null)
            return null;
        int i;
loop:
        for(i = 0;i < strs[0].length();i++){
            for(int j = 0;j < strs.length;j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i))
                    break loop;
            }
        }
        return strs[0].substring(0, i);
    }
    public static void main(String[] args){
        String[] test = {"calyle", "california", "cats"};
        System.out.println(longestCommonPrefix(test));
    }
}
