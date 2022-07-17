
https://leetcode.com/problems/rotate-array/
https://www.youtube.com/watch?v=ENcnXXiRT6E


//TC: O(N)   SC: O(N)
class Solution {
    public void rotate(int[] nums, int k) {
        int rotationFactor=k%nums.length;
        int[] result=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            result[(i+rotationFactor)%nums.length]=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=result[i];
        }
    }
}


------------------------------Optimized approach-------------------------------
  
//TC: O(N)
class Solution {
    
    public void reverse(int[] arr,int start, int end){
        while(start<=end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;end--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        int rotationFactor=k%n;
        reverse(nums,0,n-rotationFactor-1);
        reverse(nums,n-rotationFactor,nums.length-1);
        reverse(nums,0,nums.length-1);
    }
}
