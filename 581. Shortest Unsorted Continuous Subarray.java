581. Shortest Unsorted Continuous Subarray

https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

https://www.youtube.com/watch?v=p-O7FExDH1M

------------------------------------BF------------------------
TC:O(N logN)  SC:O(N)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int firstIndex=0,lastIndex=0;
        int numsCopy[]=nums.clone();
        Arrays.sort(numsCopy);
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=numsCopy[i]){
                firstIndex=i;
                break;
            }
        }
        for(int i=numsCopy.length-1;i>=0;i--){
            if(nums[i]!=numsCopy[i]){
                lastIndex=i;
                break;
            }
        }
        if(lastIndex-firstIndex==0)
            return 0;
        else
            return lastIndex-firstIndex+1;
    }
}


----------------------------------Optimised------------------------------
 TC:O(N)   SC:O(1)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        boolean sorted=true;
        int unsotredMin=Integer.MAX_VALUE,unsotredMax=Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>nums[i])
                sorted=false;
            if(!sorted)
                unsotredMin=Math.min(nums[i],unsotredMin);    
        }
        if(sorted)
            return 0;
        sorted=true;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>nums[i+1])
                sorted=false;
            if(!sorted)
                unsotredMax=Math.max(nums[i],unsotredMax);    
        }
        int l,r;
        for(l=0;l<nums.length;l++){
            if(nums[l]>unsotredMin)
                break;
        }
        for(r=nums.length-1;r>=0;r--){
            if(nums[r]<unsotredMax)
                break;
        }
        return r-l<0?0:r-l+1;
    }
}
