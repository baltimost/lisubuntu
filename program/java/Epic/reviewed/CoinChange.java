public class CoinChange{
    public static int minCoins(int sum, int[] coins){
        int[] d = new int[sum + 1];
        d[0] = 0;
        for(int i = 1;i < d.length;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0;j < coins.length;j++){
                if(i - coins[j] >= 0)//if coins is sorted, should just break;
                    min = Math.min(min, d[i - coins[j]]);
            }
            d[i] = min + 1;
        }
        return d[sum];
    }
    public static void main(String[] args){
        int[] coins = {1,2,5,10,50};
        System.out.println(minCoins(158, coins));
    }
}
