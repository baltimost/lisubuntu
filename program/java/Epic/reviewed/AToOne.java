public class AToOne{
    public static String AToOne(String str){
        StringBuilder sb = new StringBuilder();
        int i, j;
        for(i = 0, j = 0;j < str.length();j++){
            if((str.charAt(j) == 'a' || str.charAt(j) == 'A') && (j == 0 || str.charAt(j - 1) == ' ') && (j == str.length() - 1 || str.charAt(j + 1) == ' ')){
                String replacement = str.charAt(j) == 'a' ? "one" : "ONE";
                sb.append(str.substring(i, j));
                sb.append(replacement);
                i = j + 1;
            }
        }
        sb.append(str.substring(i, j));
        return sb.toString();
    }
    public static void main(String[] args){
       //String input = "A boy is playing in a garden";
        String input = " A boy is playing in a garden A";
        String rst = AToOne(input);
        System.out.println(rst);
    }
}
