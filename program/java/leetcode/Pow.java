public class Pow{
    public static double pow(double x, int n){
        if(n == 0)
            return 1;
        if(x == 0)
            return 0;
        return helper(x, n);
    }
    public static double helper(double x, int n){
        if(n == 0)
            return 1;
        double half = helper(x, n / 2);
        if(n % 2 == 0)
            return half * half;
        else
            return n > 0 ? half * half * x : half * half / x;
    }
    public static double powAlt(double x, int n){
        if(n == 0)
            return 1;
        if(x == 0)
            return 0;
        double num = x;
        if(n > 0){
            for(int i = 1;i < n;i++)
                x *= num;
        }
        else{
            x = 1;
            for(int i = 0;i < -n;i++)
                x /= num;
        }
        return x;
    }
    public static void main(String[] args){
        System.out.println(pow(0.00001,2147483340));
        System.out.println(pow(4.70975, -6));
        System.out.println(pow(4, 6));
        System.out.println("end");
        System.out.println(powAlt(0.00001,2147483340));
        System.out.println(powAlt(4.70975, -6));
        System.out.println(powAlt(4, 6));
    }
}
