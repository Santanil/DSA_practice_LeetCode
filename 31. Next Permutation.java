//31. Next Permutation
//https://leetcode.com/problems/next-permutation/
//https://www.youtube.com/watch?v=LuLCLgMElus
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0


BF Approach: To generate all the permuations with the given input and arrange them in lexecogrphical order and then find the next element
TC:O(N!*N)
  
Optimized Approach
//TC:O(N)
//SC:O(1)
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length==0 || nums.length==1)
            return;
        int i=nums.length-2,n=nums.length;
        while(i>=0 && nums[i]>=nums[i+1])
            i--;
        if(i>=0){
            int x=n-1;
            while(x>=0 && nums[x]<=nums[i])
                x--;
            swap(i,x,nums);
        }
        reverse(i+1,n-1,nums);
    }
    public void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void reverse(int i, int j,int[] nums){
        while(i<j)
            swap(i++,j--,nums);     
    }
}
