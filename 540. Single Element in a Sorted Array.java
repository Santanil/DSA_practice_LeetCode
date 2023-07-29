https://leetcode.com/problems/single-element-in-a-sorted-array/description/

--------------------------------------------Better Approach------------------------------------------------

Better approach: XOR elements
TC: O(N)
SC: O(1)

--------------------------------------------Best Approach------------------------------------------------

Approach: if there is even no of elements on both sides of mid element then middle element and the element before it should not match if all of those elements occur twice,
  accordingly we can move the left or right pointer
  Again, if there are odd no of elements on both sides of the mid element the mid and its prev element should match if till then all elemenst are in pairs. If not move right to mid-2
  else left to mid+1
  
TC: O(log N)
SC: O(1)

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l=0,r=nums.length-1;
        while(l<=r){
            if(l==r)
                return nums[l];
            int mid=r-(r-l)/2;
            if((mid-1>=0) && (mid+1<=r) && (nums[mid-1]!=nums[mid]) && (nums[mid+1]!=nums[mid]))
                return nums[mid];
            if((mid-l)%2==0){
                if(nums[mid-1]!=nums[mid])
                    l=mid;
                else
                    r=mid-1;    
            }else{
                if(nums[mid-1]!=nums[mid])
                    r=mid-1;
                else
                    l=mid+1;    
            }
        }
        return -1;    
    }
}
