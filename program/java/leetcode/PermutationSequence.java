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
            output.append(num.get(index));
            num.remove(index);
        }
        return output.toString();
    }
    public static String getPermutationAlt(int n, int k){
        StringBuilder output = new StringBuilder();
        List<Integer> num = new ArrayList<Integer>();
        k--;
        for(int i = 1;i <= n;i++)
            num.add(i);
        int factorial = getFactorial(n - 1);
        for(int i = n - 1;i >= 0;i--){
            int index = k / factorial;
            k %= factorial;
            if(i > 0)
                factorial /= i;
            output.append(num.get(index));
            num.remove(index);
        }
        System.out.println("num:" + num.size());
        return output.toString();
    }
    private static int getFactorial(int n){
        int output = 1;
        for(int i = 1;i <= n;i++)
            output *= i;
        return output;
    }
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        //System.out.println(getPermutation(3, 6));
        //System.out.println(getPermutationAlt(3, 6));
        for(int i = 1;i <= 24;i++) {
            System.out.println(getPermutationAlt(4, i));
        }
        long interval = System.currentTimeMillis() - start;
        //System.out.println(interval);
    }
}
