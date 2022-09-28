https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/

https://www.youtube.com/watch?v=xPBLEj41rFU&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=30


Approach: Total length of the string - Longest palindromic subsequence length

//TC:O(n^2)
//SC:O(n^2)
class Solution {   
    public int minInsertions(String s) {
        StringBuilder str=new StringBuilder(s);
        str.reverse();
        String s_reverse=new String(str.toString());
        int l1=s.length();
        int[][] dp=new int[l1+1][l1+1];
        int maxLen=0;
        
        //base case
        for(int i=0;i<=l1;i++)  dp[i][0]=0;
        for(int j=0;j<=l1;j++)  dp[0][j]=0;
        
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l1;j++){
                if(s.charAt(i-1)==s_reverse.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    maxLen=Math.max(maxLen,dp[i][j]);
                }else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        return l1-maxLen;
    }
}


//TC:O(n^2)
//SC:O(n)
class Solution {   
    public int minInsertions(String s) {
        StringBuilder str=new StringBuilder(s);
        str.reverse();
        String s_reverse=new String(str.toString());
        int l1=s.length();
        int[] prev=new int[l1+1];
        int maxLen=0;
        
        //base case
        for(int j=0;j<=l1;j++)  prev[j]=0;
        
        for(int i=1;i<=l1;i++){
            int[] cur=new int[l1+1];
            cur[0]=0;
            for(int j=1;j<=l1;j++){
                if(s.charAt(i-1)==s_reverse.charAt(j-1)){
                    cur[j]=1+prev[j-1];
                    maxLen=Math.max(maxLen,cur[j]);
                }else
                    cur[j]=Math.max(prev[j],cur[j-1]);
            }
            prev=cur;
        }
        
        return l1-maxLen;
    }
}
