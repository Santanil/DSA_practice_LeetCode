https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
https://www.youtube.com/watch?v=IzHR_U8Ly6c

TC:O(log N), SC:O(1)

class Solution {
    public int findMin(int[] nums) {
        int left=0,right=nums.length-1;
        int minM=Integer.MAX_VALUE;
        if(right==0)
            return nums[0];

        while(left<right){
            int mid=left+(right-left)/2;

            if(mid>0 && nums[mid]<nums[mid-1])
                return nums[mid];
            else if(nums[left]<=nums[mid] && nums[mid]>nums[right])
                left=mid+1;
            else
                right=mid-1;
        }

        //default conditin where min couldn't be found in the loop
        return nums[left];    
    }
}
