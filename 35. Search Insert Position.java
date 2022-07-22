https://leetcode.com/problems/search-insert-position/

Binary Search:

Imp:if not found return thr left ptr*****

TC:O(log N)
SC: O(1)
  
  
  class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0,right=nums.length-1,mid=0,n=nums.length;
        while(left<=right){
            mid=(left+right)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]==target)
                return mid;
        }
        return left;
    }
}
