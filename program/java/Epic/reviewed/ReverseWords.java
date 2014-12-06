public class ReverseWords{
    public static String reverseWords(String str){
        if(str == null) return null;
        StringBuilder output = new StringBuilder();
        int i, j;
        for(i = str.length() - 1, j = str.length();i >= -1;i--){
            if(i == -1 || str.charAt(i) == ' '){
                if(j - i > 1)
                    output.append(str.substring(i + 1, j) + " ");
                j = i;
            }
        }
        return output.toString().trim();
    }
    public static void main(String[] args){
        //System.out.println("-"+reverseWords(" This  is   great  ")+"-");
        System.out.println("-"+reverseWords(" i")+"-");
    }
}
