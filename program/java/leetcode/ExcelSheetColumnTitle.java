public class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        if(n <= 0) return null;
        StringBuilder reverse = new StringBuilder();
        n--;
        while(n >= 0){
            int remainder = n % 26;
            reverse.append((char)('A' + remainder));
            n = n / 26 - 1;
        }
        //reverse.append((char)('A' + n));
        StringBuilder output = new StringBuilder();
        for(int i = reverse.length() - 1;i >= 0;i--)
            output.append(reverse.charAt(i));
        return output.toString();
    }
    public static void main(String[] args){
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(26));
        System.out.println(convertToTitle(28));
    }
}
