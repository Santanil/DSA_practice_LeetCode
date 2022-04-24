525. Contiguous Array
https://leetcode.com/problems/contiguous-array/
https://www.youtube.com/watch?v=bcKrQ_avnyM

---------------------------------------BF---------------------------------------------
//TC:O(N^2)   SC:O(N)
class Solution {
    public int findMaxLength(int[] nums) {
        int ans=0,count1=0,count0=0;
        for(int i=0;i<nums.length-1;i++){
            count0=0;count1=0;
            for(int j=i;j<nums.length;j++){
                count1=nums[j]==1?(count1+1):count1;
                count0=nums[j]==0?(count0+1):count0;
                if(count0==count1)
                    ans=Math.max(ans,j-i+1);
            }
        }
        return ans;
    }
}

-----------------------------Optimized------------------------------------------------
//TC:O(N)  SC:O(N)
class Solution {
    public int findMaxLength(int[] nums) {
        int ans=0,count=0;
        HashMap<Integer,Integer> hm=new HashMap();
        hm.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                count-=1;
            else
                count+=1;
            if(hm.containsKey(count))
                ans=Math.max(ans,i-hm.get(count));
            else
                hm.put(count,i);
        }
        return ans;
    }
}




