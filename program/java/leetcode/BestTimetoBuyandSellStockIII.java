public class BestTimetoBuyandSellStockIII{
    public static int maxProfit(int[] prices){
        if(prices == null || prices.length == 0)
            return 0;
        int min = prices[0];
        int max = prices[prices.length - 1];
        int left[] = new int[prices.length];
        int right[] = new int[prices.length];
        int output = 0;
        for(int i = 1;i < prices.length;i++){
            min = prices[i] < min ? prices[i] : min;
            left[i] = prices[i] - min > left[i - 1] ? prices[i] - min : left[i - 1];
        }
        for(int i = prices.length - 2;i >= 0;i--){
            max = prices[i] > max ? prices[i] : max;
            right[i] = max - prices[i] > right[i + 1] ? max - prices[i] : right[i + 1];
        }
        for(int x:left)
            System.out.print(x + " ");
        System.out.println();
        for(int x:right)
            System.out.print(x + " ");
        System.out.println();
        for(int i = 0;i < prices.length;i++){
            output = left[i] + right[i] > output ? left[i] + right[i] : output;
        }
        return output;
    }
    public static void main(String[] args){
        int[] test0 = {6,1,3,4,7};
        int[] test1 = {6,1,3,2,4,7};
        int[] test2 = {1,2,4,2,5,7,2,4,9,0};
        System.out.println(maxProfit(test0));
        System.out.println(maxProfit(test1));
        System.out.println(maxProfit(test2));
    }
}
