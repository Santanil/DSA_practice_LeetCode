//209. Minimum Size Subarray Sum
//https://leetcode.com/problems/minimum-size-subarray-sum/
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0


//Intution: Two pointer
// r->right pointer & l->left pointer
// increasing value of r and adding new elements from right if sum<target
// in the inside loop:
// checking if sum>=target comparing the lenth of the subarray with the min length so far
//     if less update minLen
//     and keep increasing the value of left pointer to exclude the values from left subarray to decrease the overall sum
//TC: O(N)  SC:O(1)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0,minLen=Integer.MAX_VALUE,sum=0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            while(sum>=target && l<=r){
                minLen=Math.min(minLen,r-l+1);
                sum-=nums[l];
                l++;
            }      
        }
        return (minLen!=Integer.MAX_VALUE)?minLen:0;
    }
}

//TC: O(N log N)  SC:O(N)
//Intution:
//maintain a prefix sum array
//now iterate and pick one element from left and for each element selected, do a binary search on the prefix sum array on index starting after the index of the selevcted array
