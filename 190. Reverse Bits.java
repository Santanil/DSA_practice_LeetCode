https://leetcode.com/problems/reverse-bits/description/
https://www.youtube.com/watch?v=UcoN6UjAI64

TC:O(32)
  SC:O(1)
  
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res=0,bit=0;
        for(int i=0;i<32;i++){
            bit=(n>>i) & 1;
            res=res | bit<<(31-i);
        } 
        return res;   
    }
}
