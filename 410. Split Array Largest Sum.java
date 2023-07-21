https://leetcode.com/problems/split-array-largest-sum/description/

class Solution {
    public static boolean canAllocate(int[] nums,int val,int k){
        int runningSum=0,allocations=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>val)
                return false;
            if(nums[i]+runningSum>val){
                allocations++;
                runningSum=nums[i];
            }else
                runningSum+=nums[i];
        }
        if(allocations>k)
            return false;
        return true;
    }
    public static int findMin(int[] nums,int k){
        int l=Integer.MIN_VALUE,h=0;
        for(int i=0;i<nums.length;i++){
            h+=nums[i];
            l=Math.max(l,nums[i]);
        }
        while(l<=h){
            int mid=(l+h)/2;
            if(canAllocate(nums,mid,k))
                h=mid-1;
            else
                l=mid+1;
        }
        return l;
    }
    public int splitArray(int[] nums, int k) {
        return findMin(nums,k);
    }
}
