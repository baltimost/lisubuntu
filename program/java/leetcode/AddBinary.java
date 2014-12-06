public class AddBinary{
    public static String addBinary(String a, String b){
        int carry = 0;
        int len = Math.max(a.length(), b.length()) + 1;
        int[] output = new int[len];
        int i, j, k;
        for(i = a.length() - 1, j = b.length() - 1, k = len - 1;i >= 0 || j >= 0;i--, j--, k--){
            int l = i >= 0 ? a.charAt(i) - '0': 0;
            int r = j >= 0 ? b.charAt(j) - '0': 0;
            output[k] = l + r + carry;
            carry = output[k] / 2;
            output[k] = output[k] % 2;
        }
        output[k] = carry;
        StringBuilder sb = new StringBuilder();
        for(i = 0;i < len && output[i] == 0;i++);
        if(i == len)
            return "0";
        for(;i < len;i++)
            sb.append(output[i]);
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(addBinary("101","101"));
    }
}
