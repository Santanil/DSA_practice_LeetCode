https://leetcode.com/problems/unique-paths/description/
https://www.youtube.com/watch?v=t_f0nwwdg5o&t=359s

//TC: O(M*N)
//SC: O(M*N)-----------> M*N for stack space + M*N for dp array--> 2(M*N) ~ O(M*N)

class Solution {
    public int countPaths(int[][] dp, int i, int j,int m,int n){
        if(i==(m-1) && j==(n-1))
            return 1;
        if(i>=m || j>=n)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        else 
            return dp[i][j]=countPaths(dp,i+1,j,m,n)+countPaths(dp,i,j+1,m,n);
    }
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int[] x:dp)
            Arrays.fill(x,-1);
        return countPaths(dp,0,0,m,n);            
    }
}


// TC: Exponential
// SC: Exponential
class Solution {
    public int countPaths(int i, int j,int m,int n){
        if(i==(m-1) && j==(n-1))
            return 1;
        if(i>=m || j>=n)
            return 0;
        return countPaths(i+1,j,m,n)+countPaths(i,j+1,m,n);
    }
    public int uniquePaths(int m, int n) {
        return countPaths(0,0,m,n);            
    }
}
