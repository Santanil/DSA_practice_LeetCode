//560. Subarray Sum Equals K
//https://leetcode.com/problems/subarray-sum-equals-k/
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0
//https://www.youtube.com/watch?v=20v8zSo2v18


//BF approach: consider all subarrays and increase the count by 1 as soon as sum=k
//TC; O(N^2)   SC: O(1)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int l=nums.length,count=0;
        for(int i=0;i<l;i++){
            int sum=0;
            for(int j=i;j<l;j++){
                sum=sum+nums[j];
                if(sum==k)
                    count++;
            }
        }
        return count;
    }
}


//Optimized approach
//TC:O(N)  SC:O(N)
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap();
        hm.put(0,1);
        int l=nums.length,count=0,sum=0;
        for(int i=0;i<l;i++){
            sum+=nums[i];
            if(hm.containsKey(sum-k))
                count+=hm.get(sum-k);
            if(hm.containsKey(sum))
               hm.put(sum,hm.get(sum)+1);
            else
               hm.put(sum,1);
        }
        return count;
    }
}















