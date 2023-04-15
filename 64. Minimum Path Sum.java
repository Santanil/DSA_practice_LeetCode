https://leetcode.com/problems/minimum-path-sum/description/

https://www.youtube.com/watch?v=_rgTlyky1uQ

TC:O(N*M)
  SC:O(N*M)

class Solution {
    public int findMinSum(int i,int j,int[][] grid,int[][] dp){
        if(i==0 && j==0)
            return grid[i][j];
        if(i<0 || j<0)
            return (int)Math.pow(10,9);
        if(dp[i][j]!=-1)
            return dp[i][j];
        int up=grid[i][j]+findMinSum(i-1,j,grid,dp);
        int left=grid[i][j]+findMinSum(i,j-1,grid,dp);
        
        return dp[i][j]=Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return findMinSum(n-1,m-1,grid,dp);
    }
}

-----------------------------------------------------------------------------Tabulation-----------------------------------------------------------------
  class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0)
                    dp[i][j]=grid[i][j];
                else{
                    int up=grid[i][j];
                    if(i>0)
                        up+=dp[i-1][j];
                    else
                        up=(int)Math.pow(10,9);

                    int left=grid[i][j];
                    if(j>0)
                        left+=dp[i][j-1];
                    else
                        left=(int)Math.pow(10,9);

                    dp[i][j]=Math.min(up,left);
                }
            }
        }
        return dp[n-1][m-1];
    }
}


-------------------------------------------------------Space Optimization-----------------------------------------------------------------
  
  
  class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int[] prev=new int[n];
        for(int i=0;i<n;i++){
            int[] cur=new int[m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0)
                    cur[j]=grid[i][j];
                else{
                    int up=grid[i][j];
                    if(i>0)
                        up+=prev[j];
                    else
                        up=(int)Math.pow(10,9);

                    int left=grid[i][j];
                    if(j>0)
                        left+=cur[j-1];
                    else
                        left=(int)Math.pow(10,9);

                    cur[j]=Math.min(up,left);
                }
            }
            prev=cur;
        }
        return prev[m-1];
    }
}
