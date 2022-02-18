//15. 3Sum
//https://leetcode.com/problems/3sum/
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0
//https://www.youtube.com/watch?v=onLoX6Nhvmg


//BruteForce:
//Run 3 loops to iterate over all the triplets and store the triplets in a set to keep the unique triplets-> TC:O(N^3 * log M)   SC:O(M) M->size of set



//Optimized:
//Using a Hast Table in place of the 3rd loop and HashSet to store
//TC:O(N^2 *log M)    SC:O(N)+O(M) for hashtable and hashset



//Most Optimal Solution:
//Intution: Fixing the 1st element and then finding the other 2 elements using 2 pointer approach
//TC:O(N^2)   SC:O(1)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int low,high,target,l=nums.length;
        if(l<3)
            return ans;
        Arrays.sort(nums);
        for(int i=0;i<l-2;i++){
            if(i==0 || (i>0 && nums[i-1]!=nums[i])){
                target=0-nums[i];
                low=i+1;
                high=l-1;
                while(low<high){
                    if(nums[low]+nums[high]==target){
                        ans.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        while(low<high && nums[low+1]==nums[low])
                            low++;
                        while(low<high && nums[high-1]==nums[high])
                            high--;
                        low++;high--;// Important line-> missed 1st time
                    }       
                    else if(nums[low]+nums[high]>target)
                        high--;
                    else
                        low++;
                }
            }
        }
        return ans;
    }
}
