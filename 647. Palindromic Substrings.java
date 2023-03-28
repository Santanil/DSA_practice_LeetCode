https://leetcode.com/problems/palindromic-substrings/description/
similar problem -> https://www.youtube.com/watch?v=y2BD4MJqV20

TC:O(N^2)
  SC:O(1)

class Solution {
    public int countSubstrings(String s) {
        int count=0;
        if(s==null || s.length()==0)
            return 0;

        for(int i=0;i<s.length();i++){
            count+=findPalindromicLength(s,i,i);
            count+=findPalindromicLength(s,i,i+1);
        }
        return count;    
    }
    public int findPalindromicLength(String s,int left,int right){
        int count=0;
        if(s.length()==0 || left>right)
            return 0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }
}
