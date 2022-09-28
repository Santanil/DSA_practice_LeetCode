https://leetcode.com/problems/delete-operation-for-two-strings/

https://www.youtube.com/watch?v=yMnH0jrir0Q&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=32

//Approach: Find the longest common subsequence in the 2 given strings. Then ans=l1-maxLen+l2-maxLen

//Space Optimized over Tabulation
//TC:O(l1*l2)
//SC:O(max(l1,l2))
class Solution {
    public int minDistance(String word1, String word2) {
        int l1=word1.length(),l2=word2.length();
        int[] prev=new int[l2+1];
        int maxLen=0;
        
        //base case
        for(int j=0;j<=l2;j++)  prev[j]=0;
        
        for(int i=1;i<=l1;i++){
            int[] cur=new int[l2+1];
            cur[0]=0;
            for(int j=1;j<=l2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    cur[j]=1+prev[j-1];
                    maxLen=Math.max(maxLen,cur[j]);
                }else
                    cur[j]=Math.max(prev[j],cur[j-1]);
            }
            prev=cur;
        }
        
        return l1+l2-(2*maxLen);    
    }
}
