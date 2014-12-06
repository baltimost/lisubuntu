public class PlusOne{
    public static int[] plusOne(int[] digits){
        for(int i = digits.length - 1;i >= 0;i--){
            digits[i] = (digits[i] + 1) % 10;
            if(digits[i] != 0)
                break;
        }
        if(digits[0] == 0){
            int[] carry = new int[digits.length + 1];
            carry[0] = 1;
            for(int i = 1;i < carry.length;i++)
                carry[i] = digits[i - 1];
            return carry;
        }
        else
            return digits;
    }
    public static void main(String[] args){
        int[] digits = {9,9,9};
        int[] output = plusOne(digits);
        for(int x: output)
            System.out.print(x + " ");
        System.out.println();
    }
}
