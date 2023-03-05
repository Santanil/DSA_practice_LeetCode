https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
https://www.youtube.com/watch?v=-uQGzhYj8BQ&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=38

//Normal recursive solution

class Solution {
    public int findMaxProfit(int i,int buy,int cap,int[] prices,int n){
        if(i==n || cap==0)
            return 0;
        if(buy==1)
            return Math.max(-prices[i]+findMaxProfit(i+1,0,cap,prices,n),
                            0+findMaxProfit(i+1,1,cap,prices,n));
        else
            return Math.max(prices[i]+findMaxProfit(i+1,1,cap-1,prices,n),
                            0+findMaxProfit(i+1,0,cap,prices,n));
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        return findMaxProfit(0,1,2,prices,n);    
    }
}


//Memeization
TC: O(N*2*3)  SC: O(N*2*3) +O(N)
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
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][3];
        for(int[][] x:dp){
            for(int[] y:x)
                Arrays.fill(y,-1);
        }
        return findMaxProfit(0,1,2,prices,n,dp);    
    }
}
