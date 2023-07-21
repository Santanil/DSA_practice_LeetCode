https://leetcode.com/problems/majority-element/description/
https://www.youtube.com/watch?v=nP_ns3uSh80&t=873s

//Moor's Voting algorithm
class Solution {
    public int majorityElement(int[] nums) {
        int cnt=1,ele=nums[0];
        for(int i=1;i<nums.length;i++){
            if(cnt>0){
                if(ele==nums[i])
                    cnt++;
                else
                    cnt--;
            }else{
                ele=nums[i];
                cnt=1;
            }    
        }
        return ele;
    }
}



//TC: O(NlogN)
//SC: O(1)
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[(nums.length-1)/2];    
    }
}
