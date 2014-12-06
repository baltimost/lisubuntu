public class BestTimetoBuyandSellStock{
    public static int maxProfit(int[] prices){
        if(prices == null || prices.length == 0)
            return 0;
        int output = 0;
        int min = prices[0];
        for(int i = 1;i < prices.length;i++){
            if(prices[i] < min) 
                min = prices[i];
            if(prices[i] - min > output)
                output = prices[i] - min;
        }
        return output;
    }
    public static void main(String[] args){
        int[] test = {100,90,70,71,50,20,19,3};
        System.out.println(maxProfit(test));
    }
}
