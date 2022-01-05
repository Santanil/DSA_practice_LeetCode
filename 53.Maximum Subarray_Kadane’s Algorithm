53. Maximum Subarray
//BF
//  TC: O(N^2)  SC:O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0,maxSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum>maxSum)
                    maxSum=sum;
            }
        }
        return maxSum;
    }
}

// TC: O(N)  SC:O(1)
//Kadane's algo states that a subarray with a negative sum cannot contribute to largest sum hence 
//omit it and start checking from the next element.
class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0,maxSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            
            if(sum>maxSum)
                maxSum=sum;
            
            if(sum<0)
                sum=0;
        }
        return maxSum;
    }
}
