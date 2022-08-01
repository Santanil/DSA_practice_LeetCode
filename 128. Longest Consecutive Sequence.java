https://leetcode.com/problems/longest-consecutive-sequence/

TC: O(N)
SC: O(N)

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet();
        int res=0,c=1;
        for(int i=0;i<nums.length;i++)
            set.add(nums[i]);
        
        for(Integer x: set){
             if(!set.contains(x-1)){
                c=0;
                int e=x;
                while(set.contains(e++))
                    c++;
            }
            res=(c>res)?c:res;
        }
        return res;
    }
}
