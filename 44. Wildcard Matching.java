https://leetcode.com/problems/wildcard-matching/

https://www.youtube.com/watch?v=ZmlQ3vgAOMo&t=647s

Memorization
class Solution {
    public static int checkMatch(int i,String p,int j, String s,int[][] dp){
        //base case
        if(i==0 && j==0)   // no character in string and pattern hence matched
            return 1;
        if(i==0 && j>0)  //no characters remaining in patter
            return 0;
        if(i>0 && j==0){
            for(int x=i;x>0;x--){
                if(p.charAt(x-1)!='*')
                    return 0;
            }
            return 1;
        }
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        if(s.charAt(j-1)==p.charAt(i-1) || p.charAt(i-1)=='?')
            return dp[i][j]=checkMatch(i-1,p,j-1,s,dp);
        
        if(p.charAt(i-1)=='*')
            return dp[i][j]=(checkMatch(i-1,p,j,s,dp) | checkMatch(i,p,j-1,s,dp));
        return dp[i][j]=0;
    }
    public boolean isMatch(String s, String p) {
        int l1=p.length(),l2=s.length();
        int[][] dp=new int[l1+1][l2+1];
        for(int i=0;i<=l1;i++)
            Arrays.fill(dp[i],-1);
        return checkMatch(l1,p,l2,s,dp)==1?true:false;
    }
}

