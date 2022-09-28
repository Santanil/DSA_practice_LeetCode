https://leetcode.com/problems/shortest-common-supersequence/

https://www.youtube.com/watch?v=xElxAuBcvsU&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=32

//Approach: populate the dp table similar to lcs and then iterate through the dp matrox from the bottom right most cell untill i or j is 0; Keep on adding the letters accordingly
// If length is only asked in the question: ans=i+j-lcs;
//TC:O(n*m)
//SC:O(n*m)
class Solution {
    public static String shortestSupersequence(int i,int j,String str1,String str2,int[][] dp){
        StringBuilder sb=new StringBuilder();
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                sb.append(str1.charAt(i-1));
                i--;
            }else{
                sb.append(str2.charAt(j-1));
                j--;
            }
        }
        while(i>0){ sb.append(str1.charAt(i-1)); i--;}
        while(j>0){ sb.append(str2.charAt(j-1)); j--;}
        return sb.reverse().toString();
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        int l1=str1.length(),l2=str2.length();
        int[][] dp=new int[l1+1][l2+1];
        //base case
        for(int i=0;i<=l1;i++)  dp[i][0]=0;
        for(int j=0;j<=l2;j++)  dp[0][j]=0;
        
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        return shortestSupersequence(l1,l2,str1,str2,dp);    
    }
}
