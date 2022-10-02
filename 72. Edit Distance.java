https://leetcode.com/problems/edit-distance/

https://www.youtube.com/watch?v=fJaKO8FbDdo&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=34


//BF
class Solution {
    public static int findMinOp(int i,int j,String str1,String str2){
        //base case
        if(i<0)
            return j+1;
        if(j<0)
            return i+1;
        
        if(str1.charAt(i)==str2.charAt(j))
            return 0+findMinOp(i-1,j-1,str1,str2);
        
        int insert=1+findMinOp(i,j-1,str1,str2);
        int delete=1+findMinOp(i-1,j,str1,str2);
        int replace= 1+findMinOp(i-1,j-1,str1,str2);
        
        return Math.min(insert,Math.min(delete,replace));
    }
    public int minDistance(String word1, String word2) {
        int l1=word1.length(),l2=word2.length();
        return findMinOp(l1-1,l2-1,word1,word2);
    }
}


//Memoization
class Solution {
    public static int findMinOp(int i,int j,String str1,String str2,int[][] dp){
        //base case
        if(i==0)
            return j;
        if(j==0)
            return i;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(str1.charAt(i-1)==str2.charAt(j-1))
            return dp[i][j]=0+findMinOp(i-1,j-1,str1,str2,dp);
        
        int insert=1+findMinOp(i,j-1,str1,str2,dp);
        int delete=1+findMinOp(i-1,j,str1,str2,dp);
        int replace= 1+findMinOp(i-1,j-1,str1,str2,dp);
        
        return dp[i][j]=Math.min(insert,Math.min(delete,replace));
    }
    public int minDistance(String word1, String word2) {
        int l1=word1.length(),l2=word2.length();
        int[][] dp=new int [l1+1][l2+1];
        for(int i=0;i<=l1;i++)
            Arrays.fill(dp[i],-1);
        return findMinOp(l1,l2,word1,word2,dp);
    }
}


//Tabulation
class Solution {
    public int minDistance(String word1, String word2) {
        int l1=word1.length(),l2=word2.length();
        int[][] dp=new int [l1+1][l2+1];
        for(int i=0;i<=l1;i++)
            dp[i][0]=i;
        for(int j=0;j<=l2;j++)
            dp[0][j]=j;
        
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=0+dp[i-1][j-1];
                else{
                    int insert=1+dp[i][j-1];
                    int delete=1+dp[i-1][j];
                    int replace= 1+dp[i-1][j-1];

                    dp[i][j]=Math.min(insert,Math.min(delete,replace)); 
                }
            }
        }
        return dp[l1][l2];
    }
}


//Space Optimization
class Solution {
    public int minDistance(String word1, String word2) {
        int l1=word1.length(),l2=word2.length();
        int[] prev=new int [l2+1];
        for(int j=0;j<=l2;j++)
            prev[j]=j;
        
        for(int i=1;i<=l1;i++){
            int[] cur=new int[l2+1];
            cur[0]=i;
            for(int j=1;j<=l2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    cur[j]=0+prev[j-1];
                else{
                    int insert=1+cur[j-1];
                    int delete=1+prev[j];
                    int replace= 1+prev[j-1];

                    cur[j]=Math.min(insert,Math.min(delete,replace)); 
                }
            }
            prev=cur;
        }
        return prev[l2];
    }
}
