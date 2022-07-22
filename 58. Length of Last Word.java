https://leetcode.com/problems/length-of-last-word/


TC: O(N)
SC:O(N)
class Solution {
    public int lengthOfLastWord(String s) {
        String str=s.trim();
        int i=str.length()-1,res=0;
        while(i>=0 && str.charAt(i)!=' '){
            res++;
            i--;
        }
        return res;
    }
}


TC: O(N)
SC:O(N)
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int lastIndex = s.lastIndexOf(' ') + 1;
        return s.length() - lastIndex;        
    }
}
