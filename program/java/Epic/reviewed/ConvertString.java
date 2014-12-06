public class ConvertString{
    public static String convertString(String str, int shift){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < str.length();i++){
            char base = str.charAt(i) <= 'z' && str.charAt(i) >= 'a' ?
                'a' : 'A';
            sb.append((char)((str.charAt(i) - base + shift) % 26 + base));
        }
        return sb.toString();
    }
    public static void main(String[] args){
        String rst = convertString("abcDz", 2);
        System.out.println(rst);
    }
}
