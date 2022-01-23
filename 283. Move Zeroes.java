
//283. Move Zeroes
//https://leetcode.com/problems/move-zeroes/
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0

//TC: O(N+M) SC:O(1)  //M=no of 0s
//here we are copying all the non-zero elements and placing them from 1st index and 
//storing the updating and storing the index of last non-zero placed +1
//after 1st iteration, we are placing the putting zeros from the pointer till the end of array
class Solution {
    public void moveZeroes(int[] nums) {
        if(!(nums.length==0 || nums.length==1)){
            int ptr=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=0){
                    nums[ptr]=nums[i];
                    ptr++;
                }
            }
            while(ptr<nums.length){
                nums[ptr]=0;
                ptr++;
            }
        }
    }
}


//TC: O(N)  SC:O(N)
//Here we are maintaing 2 ptrs.
//zeroPtr-> pointing to index of last 0 element
//nonZeroPtr-> ptr to traverse and check if its nonZero swap the values with value at zeroPtr index and update both by 1
class Solution {
    public void moveZeroes(int[] nums) {
        int zeroPtr=0,nonZeroPtr=0,temp=0;
        while(nonZeroPtr<nums.length){
            if(nums[nonZeroPtr]!=0){
                temp=nums[zeroPtr];
                nums[zeroPtr]=nums[nonZeroPtr];
                nums[nonZeroPtr]=temp;
                nonZeroPtr++;
                zeroPtr++;
            }else
                nonZeroPtr++;  
        }
    }
}
