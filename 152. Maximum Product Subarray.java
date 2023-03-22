https://leetcode.com/problems/maximum-product-subarray/description/
https://www.youtube.com/watch?v=QQVCKkImH_s


TC:O(N)
  SC:O(1)
    
    
class Solution {
    public int maxProduct(int[] nums) {
        int l=nums.length;
        
        int minM=nums[0];
        int maxM=nums[0];
        int res=nums[0];

        //return directly if only one element present
        if(l<2)
            return res;

        for(int i=1;i<l;i++){
                int temp=maxM;
                maxM=Math.max(maxM*nums[i],minM*nums[i]);
                maxM=Math.max(maxM,nums[i]);

                minM=Math.min(temp*nums[i],minM*nums[i]);
                minM=Math.min(minM,nums[i]);
                res=Math.max(maxM,res);
        }

        return res;
    }
}
