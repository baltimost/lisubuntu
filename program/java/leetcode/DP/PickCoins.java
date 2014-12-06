public class PickCoins{
    public static int minofCoins(int[] coins, int sum){
        int[] d = new int[sum + 1];
        d[0] = 0;
        for(int i = 1;i <= sum;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0;j < coins.length && coins[j] <= i;j++)
                min = Math.min(min, d[i - coins[j]]);
            d[i] = min + 1;
        }
        return d[sum];
    }
    public static void main(String[] args){
        int[] test = {1,3,5};
        //for(int i = 0;i < 12;i++){
            System.out.println(minofCoins(test, 100));
        //}
        int[] arr = new int[10];
    }
}
