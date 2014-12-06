import java.util.*;

public class PermutationSequence{
    /*
    static String rst = "";
    static int count = 0;
    public static String getPermutation(int n, int k){
        StringBuilder output = new StringBuilder();
        helper(n, k, output);
        return rst;
    }
    public static void helper(int n, int k, StringBuilder output){
        if(!rst.equals(""))
            return;
        if(output.length() == n){
            count++;
            if(count == k){
                rst = output.toString();
            }
            return;
        }
        for(int i = 1;i <= n;i++){
            String num = String.valueOf(i);
            if(output.toString().contains(num))
                continue;
            output.append(num);
            helper(n, k, output);
            output.deleteCharAt(output.length() - 1);
        }
    }
    */
    public static String getPermutation(int n, int k){
        int factorial = 1;
        StringBuilder output = new StringBuilder();
        ArrayList<Integer> num = new ArrayList<Integer>();
        k--;
        for(int i = 1;i <= n;i++)
            num.add(i);
        for(int i = 2;i < n;i++)
            factorial *= i;
        for(int i = 0;i < n;i++){
            int index = k / factorial;
            k %= factorial;
            if(n - i - 1 > 0)
                factorial /= (n - i - 1);
            System.out.println(index);
            output.append(num.get(index));
            System.out.println(output.toString());
            num.remove(index);
        }
        return output.toString();
    }
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        String output = getPermutation(1, 1);
        System.out.println(output);
        long interval = System.currentTimeMillis() - start;
        System.out.println(interval);
    }
}
