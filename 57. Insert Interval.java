https://leetcode.com/problems/insert-interval/description/
https://www.youtube.com/watch?v=NWM4e4yda0w&t=306s

TC:O(N)
  SC:O(1)
    
    
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res=new ArrayList<>();

        for(int[] in:intervals){
            if(in[1]<newInterval[0])
                res.add(in);
            else if(in[0]>newInterval[1]){
                res.add(newInterval);
                newInterval=in;
            }else{
                newInterval[0]=Math.min(newInterval[0],in[0]);
                newInterval[1]=Math.max(newInterval[1],in[1]);
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}
