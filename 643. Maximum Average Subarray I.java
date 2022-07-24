https://leetcode.com/problems/maximum-average-subarray-i/


**************************************************************Naive******************************************************
TC:O(N^2)
SC: O(1)
  
  
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0, maxSum=Integer.MIN_VALUE; 
        for(int i=0;i<k;i++)
            sum+=nums[i];
        maxSum=sum;
        for(int i=1;i<nums.length-k+1;i++){
            sum=0;
            for(int j=0;j<k;j++)
                sum+=nums[j+i];
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum/k;
    }
}

************************************************Optimized*******************************************************************
Sliding window
TC: O(N)
SC: O(1)
  
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        double sum=0;
        
        for(int i=0;i<k;i++)
            sum+=nums[i];
        
        double maxSum=sum;
        
        for(int i=k;i<nums.length;i++){
            sum+=nums[i]-nums[i-k];
            maxSum=Math.max(maxSum,sum);
        }
        
        return maxSum/k;
    }
}
