public class ExcelSheetColumnNumber{
    public static int titleToNumber(String s){
        int output = s.charAt(s.length() - 1) - 'A';
        int factor = 26;
        for(int i = s.length() - 2;i >= 0;i--){
            output += ((s.charAt(i) + 1 - 'A') * factor);
            factor *= 26;
        }
        return output + 1;
    }
    public static void main(String[] args){
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("AA"));
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("Z"));
    } 
}
