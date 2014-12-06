public class ClimbingStairs{
    public static int climbStairs(int n){
        int[] d = new int[n + 1];
        d[0] = 1;
        d[1] = 1;
        for(int i = 2;i < n + 1;i++){
            d[i] = d[i - 2] + d[i - 1];
        }
        return d[n];
    }
    public static void main(String[] args){
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(6));
    }
}
