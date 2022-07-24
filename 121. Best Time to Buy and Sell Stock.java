https://leetcode.com/problems/best-time-to-buy-and-sell-stock/


*********************************************Naive****************************************
TC: O(N^2)
SC: O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int profit=0,maxProfit=0;
        if(prices.length==1)
            return 0;
        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                profit=prices[j]-prices[i];
                maxProfit=Math.max(profit,maxProfit);
            }
        }
        return maxProfit;
    }
}



*********************************************Optimized****************************************

TC: O(N)
SC: O(1)
  
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==1)
            return 0;
        int minValue=prices[0], maxProfit=0;
        for(int i=1;i<prices.length;i++){
            maxProfit=Math.max(maxProfit,prices[i]-minValue);
            minValue=Math.min(minValue,prices[i]);
        }
        return maxProfit;
    }
}
