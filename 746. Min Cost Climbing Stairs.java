https://www.youtube.com/watch?v=OoGswqFU-zs&t=134s

class Solution {
    int getMinCost(int ind,List<Integer> cost){
        if(ind==0 || ind==1)
            return cost.get(ind);
        int left=cost.get(ind)+getMinCost(ind-1,cost);
        int right=Integer.MAX_VALUE;
        if(ind>1)
            right=cost.get(ind)+getMinCost(ind-2,cost);
        return Math.min(left,right);
    }
    public int minCostClimbingStairs(int[] c) {
        List<Integer> al=new ArrayList<>();
        for(int x:c)
            al.add(x);
        al.add(0);
        return getMinCost(al.size()-1,al);                
    }
}

TC:O(N)
SC:O(N)
class Solution {
    int getMinCost(int[] c){
        List<Integer> cost=new ArrayList<>();
        for(int x:c)
            cost.add(x);
        cost.add(0);
        int[] dp=new int[cost.size()+1];
        dp[0]=cost.get(0);
        dp[1]=cost.get(1);
        for(int i=2;i<cost.size();i++){
            dp[i]=cost.get(i)+Math.min(dp[i-1],dp[i-2]);
        }
        return dp[cost.size()-1];
    }
    public int minCostClimbingStairs(int[] c) {
        return getMinCost(c);                   
    }
}



class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int step1=0;
        int step2=0;
        for(int i=cost.length-1;i>=0;i--){
            int cur=cost[i]+Math.min(step1,step2);
            step1=step2;
            step2=cur;
        }
        return Math.min(step1,step2);
    }
}
