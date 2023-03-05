//Normal recursive solution
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
https://www.youtube.com/watch?v=nGJmxkUJQGs&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=37


TC: O(2^N)  SC:O(N)
class Solution {
    public int findMaxProfit(int i,boolean buy,int[] prices,int n){
        if(i==n)
            return 0;
        if(buy)
            return Math.max(-prices[i]+findMaxProfit(i+1,false,prices,n),
                            0+ findMaxProfit(i+1,true,prices,n));
        else
            return Math.max(prices[i]+findMaxProfit(i+1,true,prices,n),
                            0+ findMaxProfit(i+1,false,prices,n));
    }
    public int maxProfit(int[] prices) {
        return findMaxProfit(0,true,prices,prices.length);
    }
}

//Memoization solution
TC: O(2N)  SC:O(1N)
class Solution {
    public int findMaxProfit(int i,int buy,int[][] dp,int[] prices,int n){
        if(i==n)
            return 0;
        if(dp[i][buy]!=-1)
            return dp[i][buy];
        if(buy==1)
            return dp[i][buy]=Math.max(-prices[i]+findMaxProfit(i+1,0,dp,prices,n),
                            0+ findMaxProfit(i+1,1,dp,prices,n));
        else
            return dp[i][buy]=Math.max(prices[i]+findMaxProfit(i+1,1,dp,prices,n),
                            0+ findMaxProfit(i+1,0,dp,prices,n));
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return findMaxProfit(0,1,dp,prices,n);
    }
}
