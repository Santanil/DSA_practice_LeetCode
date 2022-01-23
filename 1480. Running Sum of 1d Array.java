// 1480. Running Sum of 1d Array

class Solution {
    public static int[] runningSum(int[] nums) {
	        int op[]=new int[nums.length];
	        int sum=0;
	        for(int i=0;i<nums.length;i++) {
	            op[i]=sum+nums[i];
	            sum=op[i];
	        }
	        return op;
	    }
}
