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



//Space Optimized Approach

//TC:O(N! * N)-> N! to get each possible permutation and for each we are looping from index till N and also for copying the nums into our actual ds ie res here
//SC:O(1) Constant space just using the stack space for recursion and is counted under auxilary space 
//Auxilary Space: O(N) for recursion call as the depth will be N
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        //boolean[] freq=new boolean[nums.length];
        getPermute(0,nums,res);
        return res;
    }
    public void swap(int i,int j,int[] arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void getPermute(int index,int[] arr,List<List<Integer>> res){
        //base case
        if(index==arr.length){
            List<Integer> ds=new ArrayList<>();
            for(int i=0;i<arr.length;i++)
                ds.add(arr[i]);
            res.add(ds);
            return;
        }
    
        for(int i=index;i<arr.length;i++){
            swap(i,index,arr);
            getPermute(index+1,arr,res);
            swap(index,i,arr);
        }
    }
}
