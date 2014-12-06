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
   public static void main(String[] args){
       int[] test = {87,99,98,100,88,30,40,32,70,3,4,10};
       System.out.println(maxProfit(test));
   }
}
