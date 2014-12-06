public class MultiplyStrings{
    public static String multiply(String num1, String num2){
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0)
            return "";
        int len1 = num1.length();
        int len2 = num2.length();
        int[] num3 = new int[len1 + len2];
        int carry = 0;
        int i,j;
        for(i = len1 - 1;i >= 0;i--){
            carry = 0;
            for(j = len2 - 1;j >= 0;j--){
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carry + num3[i + j + 1]; 
                num3[i + j + 1] = product % 10; 
                carry = product / 10;
            }
            num3[i + j + 1] = carry;
        }
        for(i = 0;num3[i] == 0 && i < num3.length;i++);
        if(i == num3.length)
            return "0";
        StringBuilder sb = new StringBuilder();
        for(;i < num3.length;i++)
            sb.append(num3[i]);
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(multiply("999","999"));
    } 
}
