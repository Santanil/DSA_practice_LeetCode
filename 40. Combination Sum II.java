//40. Combination Sum II
//https://leetcode.com/problems/combination-sum-ii/
//https://www.youtube.com/watch?v=G1fRTGRxXU8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=9
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        combo(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
    public void combo(int index,int[] arr,int target,List<List<Integer>> ans,List<Integer> list){
        //base case
        if(target==0){
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        
        
        for(int i=index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1])
                continue;
            if(arr[i]>target)
                break;
            list.add(arr[i]);
            combo(i+1,arr,target-arr[i],ans,list);
            list.remove(list.size()-1);        
        }
               
    }
}
