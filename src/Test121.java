/**
 * author jmh
 */
public class Test121 {
    public int maxProfit(int[] prices){
        int tempMinPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > tempMinPrice){
                maxProfit = Math.max(prices[i] - tempMinPrice, maxProfit);
            }else{
                tempMinPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
