https://leetcode.com/problems/rotate-string/


Best Approach**************************************************

KMP string matching algorithm
(Knuth Morris Pratt Algorithm)


TC:O(N+M)
SC:O(1)

class Solution {
    public boolean rotateString(String s, String goal) {
        return s.length()==goal.length() && (s+s).contains(goal);
    }
}
