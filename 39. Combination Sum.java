//39. Combination Sum
//https://leetcode.com/problems/combination-sum/
//https://www.youtube.com/watch?v=OyZFFqQtu98&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=8
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0


//TC: O((2^t)*k)  SC:O(k*x)
//where k is the avg size of the list<ds used>
//t is the target value
//x no. of combinations possible
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        combo(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
    public void combo(int index,int[] arr,int target,List<List<Integer>> ans,List<Integer> list){
        //base case
        if(index==arr.length){
            if(target==0)
                ans.add(new ArrayList<Integer>(list));
            return;
        }
        
        if(arr[index]<=target){
            list.add(arr[index]);
            combo(index,arr,target-arr[index],ans,list);
            list.remove(list.size()-1);
        }
        combo(index+1,arr,target,ans,list);
    }
}
