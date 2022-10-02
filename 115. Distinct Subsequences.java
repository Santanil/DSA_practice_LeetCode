https://leetcode.com/problems/distinct-subsequences/
https://www.youtube.com/watch?v=nVG7eTiD2bY&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=33


//BF
class Solution {
    public static int count(int i, int j, String s, String t){
        //base case
        if(j<0)
            return 1;
        if(i<0)
            return 0;        
        if(s.charAt(i)==s.charAt(j))
            return count(i-1,j-1,s,t)+count(i-1,j,s,t);
        else
            return count(i-1,j-1,s,t);
    }
    public int numDistinct(String s, String t) {
        int sl=s.length(),tl=t.length();
        return count(sl-1,tl-1,s,t);
    }
}


//Memoization
class Solution {
    public static int count(int i, int j, String s, String t,int[][] dp){
        //base case
        if(j==0)
            return 1;
        if(i==0)
            return 0;    
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(s.charAt(i-1)==t.charAt(j-1))
            return dp[i][j]=count(i-1,j-1,s,t,dp)+count(i-1,j,s,t,dp);
        else
            return dp[i][j]=count(i-1,j,s,t,dp);
    }
    public int numDistinct(String s, String t) {
        int sl=s.length(),tl=t.length();
        int[][] dp=new int[sl+1][tl+1];
        for(int i=0;i<=sl;i++)
            Arrays.fill(dp[i],-1);
        return count(sl,tl,s,t,dp);
    }
}


//Tabulation
class Solution {
    public int numDistinct(String s, String t) {
        int sl=s.length(),tl=t.length();
        int[][] dp=new int[sl+1][tl+1];
            
            
        for(int i=0;i<=sl;i++)
            dp[i][0]=1; //when j=0, that means the target has been achieved
        for(int j=1;j<=tl;j++)
            dp[0][j]=0;
            
        for(int i=1;i<=sl;i++){
                for(int j=1;j<=tl;j++){
                        if(s.charAt(i-1)==t.charAt(j-1))
                            dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                        else
                            dp[i][j]=dp[i-1][j];
                }
        }
        return dp[sl][tl];
    }
}


//Space Optimization
class Solution {
    public int numDistinct(String s, String t) {
        int sl=s.length(),tl=t.length();
        int[] prev=new int[tl+1];
            
        for(int j=0;j<=tl;j++)
            prev[j]=0;
        prev[0]=1;    
        for(int i=1;i<=sl;i++){
            int[] cur=new int[tl+1];
            cur[0]=1;
            for(int j=1;j<=tl;j++){
                if(s.charAt(i-1)==t.charAt(j-1))
                    cur[j]=prev[j-1]+prev[j];
                else
                    cur[j]=prev[j];
            }
            prev=cur;
        }
        return prev[tl];
    }
}


