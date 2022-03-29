// 45. Jump Game II
// https://leetcode.com/problems/jump-game-ii/
//https://www.youtube.com/watch?v=a9r98S-pDvk
// https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0

//greedy approach
//TC:O(N)
//SC:O(1)
class Solution {
    public int jump(int[] nums) {
        int curReach=0,jumps=0,maxReach=0;
        for(int i=0;i<nums.length-1;i++){
            if((nums[i]+i)>maxReach)
                maxReach=nums[i]+i;
            if(i==curReach){
                curReach=maxReach;
                jumps++;
            }
        }
        return jumps;
    }
}
