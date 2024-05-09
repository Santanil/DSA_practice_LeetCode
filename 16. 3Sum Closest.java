//TC:O(N^2)   SC:O(1)

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i=0,res=0,diff=0,minDiff=Integer.MAX_VALUE,j=0,k=0,sum=0;
        while(i<nums.length){
            j=i+1;
            k=nums.length-1;
            while(j<k){
                sum=nums[i]+nums[j]+nums[k];
                diff=Math.abs(target-sum);
                if(diff<minDiff){
                    res=sum;
                    minDiff=diff;
                }
                if(sum<target)
                    j++;
                else if(sum>target)
                    k--;
                else
                    return target;    
            }
            i++;
            while(i<nums.length && nums[i]==nums[i-1]) 
                i++;    
        }
        return res;    
    }
}
