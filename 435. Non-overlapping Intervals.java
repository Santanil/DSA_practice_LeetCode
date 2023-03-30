https://leetcode.com/problems/non-overlapping-intervals/description/
https://www.youtube.com/watch?v=BTObFnHbD4U

TC:O(N log N)
  SC:O(1)
    
    
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count=0,l=intervals.length;

        if(l==1)
            return count;

        //sort wrt 1st element
        java.util.Arrays.sort(intervals, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Double.compare(a[0], b[0]);
            }
        });

        int left=0, right=1;
        while(right<l){

            //non overlapping
            if(intervals[left][1]<=intervals[right][0]){
                left=right;
                right++;
            }
            //overlapping and right's right > left's right: remove right
            else if(intervals[left][1]<=intervals[right][1]){
                right++;
                count++;    
            }
            //left overshadows right: remove left
            else if(intervals[left][1]>intervals[right][1]){
                left=right;
                right++;
                count++;
            }
            
        }
        return count;
    }
}
