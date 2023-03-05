https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
https://www.youtube.com/watch?v=-uQGzhYj8BQ&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=38

TC: O(N*2*k) SC: O(N*2*k)+O(N)
class Solution {
    public int findMaxProfit(int i,int buy,int cap,int[] prices,int n,int[][][] dp){
        if(i==n || cap==0)
            return 0;
        if(dp[i][buy][cap]!=-1)
            return dp[i][buy][cap];
        if(buy==1)
            return dp[i][buy][cap]=Math.max(-prices[i]+findMaxProfit(i+1,0,cap,prices,n,dp),
                            0+findMaxProfit(i+1,1,cap,prices,n,dp));
        else
            return dp[i][buy][cap]=Math.max(prices[i]+findMaxProfit(i+1,1,cap-1,prices,n,dp),
                            0+findMaxProfit(i+1,0,cap,prices,n,dp));
    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][k+1];
        for(int[][] x:dp){
            for(int[] y:x)
                Arrays.fill(y,-1);
        }
        return findMaxProfit(0,1,k,prices,n,dp);    
    }
}
