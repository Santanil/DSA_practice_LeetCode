//56. Merge Intervals
//https://leetcode.com/problems/merge-intervals/
//https://www.youtube.com/watch?v=2JzRBPFYbKE&t=15s
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0


//Optimized
//TC:O(log N)+O(N)
//SC:O(1)
class Solution {
    public int[][] merge(int[][] arr) {
        List<int[]> res=new ArrayList<>();
        //Sort the array
        Arrays.sort(arr,(a,b)->a[0] - b[0]);
        
        int start=arr[0][0];
        int end=arr[0][1];
        
        for(int i=1;i<arr.length;i++){
            if(arr[i][0]<=end){
                if(arr[i][0]<start)
                    start=arr[i][0];
                if(arr[i][1]>end)
                    end=arr[i][1];
            }else{
                res.add(new int[]{start,end});
                start=arr[i][0];
                end=arr[i][1];
            }
        }
        res.add(new int[]{start,end}); // to add the last stored pair
        return res.toArray(new int[0][]);
    }
}
