70. Climbing Stairs
https://leetcode.com/problems/climbing-stairs/
https://www.youtube.com/watch?v=mLfjzJsN8us&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=3

//TC:O(2^N)
//SC:O(N)
class Solution {
    public int climbStairs(int n) {
        if(n==0)
            return 1;  //one way to keep standing at 0
        if(n==1)
            return 1;
        int left=climbStairs(n-1);
        int right=climbStairs(n-2);
        return left+right;
    }
}


//Memoization
//TC: O(N)
//SC: O(N)
class Solution {
    int computeSteps(int n, int[] dp){
        if(n==0)
            return 1;  //one way to keep standing at 0
        if(n==1)
            return 1;
        if(dp[n]!=-1)
            return dp[n];
        int left=climbStairs(n-1);
        int right=climbStairs(n-2);
        return dp[n]=left+right;    
    }
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return computeSteps(n,dp);
    }
}


//Tabulation
//TC:O(N)
//SC:O(N)
class Solution {
    int computeSteps(int n, int[] dp){
        dp[0]=dp[1]=1;
        for(int i=2;i<=n;i++)
            dp[i]=dp[i-1]+dp[i-2];
        
        return dp[n];
    }
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        return computeSteps(n,dp);
    }
}
