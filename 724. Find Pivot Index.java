https://leetcode.com/problems/find-pivot-index/
https://www.youtube.com/watch?v=0PiH6Beqif8

***********************************Naive*********************************
TC: O(3N)
SC: O(2N)
class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int[] left=new int[n+1];    
        int[] right=new int[n+1];
        left[0]=0;
        right[n]=0;
        for(int i=0;i<n;i++)
            left[i+1]+=left[i]+nums[i];
        for(int i=n-1;i>=0;i--)
            right[i]+=right[i+1]+nums[i];
        for(int i=0;i<n;i++){
            if(left[i]==right[i+1])
                return i;
        }
        return -1;
    }
}


***********************************Optimized*********************************


TC:O(N)
SC:O(1)
class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum=0,leftSum=0;
        for(int i=0;i<nums.length;i++)
            totalSum+=nums[i];
        
        for(int i=0;i<nums.length;i++){
            if(totalSum-leftSum-nums[i]==leftSum)
                return i;
            leftSum+=nums[i];
        }
        return -1;
    }
}
