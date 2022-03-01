//46. Permutations
//https://leetcode.com/problems/permutations/
//https://www.youtube.com/watch?v=YK78FU5Ffjw&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=12
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0


//TC:O(N! * N)-> N! to get each possible permutation and for each we are looping from 0 to N
//SC:O(2N) -> O(N) to store list and O(N) to store freq
//Auxilary Space: O(N) for recursion call as the depth will be N
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        boolean[] freq=new boolean[nums.length];
        getPermute(nums,freq,new ArrayList<Integer>(),res);
        return res;
    }
    public void getPermute(int[] arr,boolean[] freq,ArrayList<Integer> list,List<List<Integer>> res){
        //base case
        if(list.size()==arr.length){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=0;i<arr.length;i++){
            if(!freq[i]){
                freq[i]=true;
                list.add(arr[i]);
                getPermute(arr,freq,list,res);
                list.remove(list.size()-1);
                freq[i]=false;
            }
        }
    }
}
