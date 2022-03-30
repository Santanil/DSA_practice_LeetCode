//78. Subsets
//https://leetcode.com/problems/subsets/
//https://www.youtube.com/watch?v=iKSI_9NHR1M
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0

//TC: O(2^N * N)-> 2^N for outer loop and N for the inner loop
//SC: O(1)
class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> list=new ArrayList<>();
        int limit= (int) Math.pow(2,arr.length);
        for(int i=0;i<limit;i++){
            int temp=i;
            List<Integer> l=new ArrayList<>();
            for(int j=arr.length-1;j>=0;j--){
                int res=temp%2;
                temp=temp/2;
                
                if(res==1)
                    l.add(arr[j]);
            }
            Collections.reverse(l);
            list.add(l);
        }
        return list;
    }
}



Solution using bit manipulation

//TC: O(2^N * N)-> 2^N for outer loop and N for the inner loop
//SC: O(1)
class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> res=new ArrayList<>();
        int n=arr.length;
        for(int i=0;i<(1<<n);i++){
            List<Integer> sublist=new ArrayList<>();
            for(int j=0;j<n;j++){
                if( (i & (1<<j))!=0)
                    sublist.add(arr[j]);
            }
            res.add(sublist);
        }
        return res;
    }
}
