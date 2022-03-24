//1235. Maximum Profit in Job Scheduling
//https://leetcode.com/problems/maximum-profit-in-job-scheduling/
//https://www.youtube.com/watch?v=ZOP43iB_E_8
//https://www.youtube.com/watch?v=3kU7VYcmffU


class Solution {
    private class Job{
        private int startTime;
        private int endTime;
        private int profit;
        public Job(int startTime,int endTime,int profit){
            this.startTime=startTime;
            this.endTime=endTime;
            this.profit=profit;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs=new ArrayList<>();
        for(int i=0;i<startTime.length;i++)
            jobs.add(new Job(startTime[i],endTime[i],profit[i]));
        
        //Sorted in ascending order of endTime
        Collections.sort(jobs, (a,b)->(a.endTime - b.endTime));
        
        int ans=0;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(Job currentJob:jobs){
            Integer lastJobEndTime = map.floorKey(currentJob.startTime);
            int maxProfit= (lastJobEndTime==null)?0:map.get(lastJobEndTime);
            ans = Math.max(ans, maxProfit+currentJob.profit);
            map.put(currentJob.endTime, ans);
        }
        return ans;
    }
}
