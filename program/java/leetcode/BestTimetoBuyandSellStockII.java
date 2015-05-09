public class BestTimetoBuyandSellStockII{
   public static int maxProfit(int[] prices){
      if(prices == null || prices.length == 0)
         return 0;
      int output = 0;
      int min = prices[0];
      for(int i = 1;i < prices.length;i++){
          if(prices[i] < prices[i - 1]){
              int tmp = prices[i - 1] - min;
              output += tmp;
              min = prices[i];
          }
      }
      output = output + prices[prices.length - 1] - min;
      return output;
   } 

   public static int maxProfitAltern(int[] prices){
       if(prices == null || prices.length == 0)
           return 0;
       int output = 0;
       for(int i = 0, j = 1;j <= prices.length;j++){
           if(j == prices.length || prices[j] < prices[j - 1]){
               output += prices[j - 1] - prices[i];
               i = j;
           }
       }
       return output;
   }
   public static int maxProfitAlt(int[] prices) {
       if(prices == null || prices.length == 0) {
           return 0;
       }
       int output = 0;
       for(int i = 1;i < prices.length;i++) {
           output += prices[i] - prices[i - 1] > 0 ? prices[i] - prices[i - 1] : 0;
       }
       return output;
   }
   public static void main(String[] args){
       int[] test = {87,99,98,100,88,30,40,32,70,3,4,10};
       //int[] test = {60,71,49,11,82,49,3,66};
       System.out.println(maxProfit(test));
       System.out.println(maxProfitAlt(test));
   }
}
