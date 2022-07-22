https://leetcode.com/problems/sort-colors/

https://www.youtube.com/watch?v=oaVa-9wmpns


Naive approach---------------------------------------------------->  Sort the array 
TC:O(NlogN)
SC:O(1)
  
  
Better Solution---------------------------------------------------->  using counting sort/using move zeros algo with 2 passes one from left and one from right
TC:O(2N)
SC:O(1)
  
 
move zeros algo with 2 passes
class Solution {
    public void sortColors(int[] nums) {
        int left=0,right=0,temp;
        
        //accumulate all 0s at the starting of the array
        while(right<nums.length){
            if(nums[right]==0){
                temp=nums[right];
                nums[right]=nums[left];
                nums[left]=temp;
                left++;
            }
            right++;
        }
        
        //accumulate all 2sat the end of the array
        left=nums.length-1;right=nums.length-1;
        while(left>=0){
          if(nums[left]==2){
              temp=nums[left];
              nums[left]=nums[right];
              nums[right]=temp;
              right--;
          }
          left--;
        }
    }
}



Best Solution:  Dutch National Flag algorithm  ----------------------------> 1 pass solution
TC: O(N)
SC:O(1)

class Solution {
    public void sortColors(int[] nums) {
        int left=0,mid=0,right=nums.length-1,temp;
        while(mid<=right){
            if(nums[mid]==0){
                temp=nums[mid];
                nums[mid]=nums[left];
                nums[left]=temp;
                left++;
                mid++;
            }else if(nums[mid]==2){
                temp=nums[mid];
                nums[mid]=nums[right];
                nums[right]=temp;
                right--;
            }else{
                mid++;
            }
        }
    }
}
