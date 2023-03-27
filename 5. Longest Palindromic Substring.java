https://leetcode.com/problems/longest-palindromic-substring/description/
https://www.youtube.com/watch?v=y2BD4MJqV20


TC:O(N^2)
  SC:O(1)
    
class Solution {
    public String longestPalindrome(String s) {
        int start=0,end=0;
        if(s==null || s.length()<1)
            return "";
        for(int i=0;i<s.length();i++){
            int len1=findLenghtFromMiddle(s,i,i);
            int len2=findLenghtFromMiddle(s,i,i+1);
            int maxLen=Math.max(len1,len2);

            if(maxLen>(end-start)){
                start=i-((maxLen-1)/2);
                end=i+(maxLen/2);
            }
        }
            return s.substring(start,end+1);
    }    
    int findLenghtFromMiddle(String s,int left,int right){
        if(s==null || left>right)
            return 0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
} 
