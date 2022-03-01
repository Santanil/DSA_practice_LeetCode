//90. Subsets II
//https://leetcode.com/problems/subsets-ii/
//https://www.youtube.com/watch?v=RIn3gOkbhQE&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=11
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0




//TC:O(2^N *N)-> 2^n for recursion for generating subsets ans for each we need to copy the list values to our resultant List(res) which will take a TC of O(N)

//SC: O(2^n * k)-> 2^n for storing the 2^n no of subsets possible and for each taking an average length of k

//Auxilary space: O(N) as the recursion will have a depth = the no of elements present in the nums array
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);    
        subsetList(0,nums,res,new ArrayList<>());
        return res;
    }
    
    public void subsetList(int index,int[] nums,List<List<Integer>> res,List<Integer> list){
        // if(index==nums.length)
        //     return;
        res.add(new ArrayList<>(list));
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]) continue;
            list.add(nums[i]); 
            subsetList(i+1,nums,res,list);
            list.remove(list.size()-1);
        }
    }
}
