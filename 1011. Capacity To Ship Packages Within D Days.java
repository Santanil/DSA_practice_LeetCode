https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

class Solution {
    public static boolean canAllocate(int[] weights,int x,int days){
        int sum=0,noOfDays=1;
        for(int i=0;i<weights.length;i++){
            if(weights[i]>x) return false;
            if(weights[i]+sum>x){
                sum=weights[i];
                noOfDays++;
            }else{
                sum+=weights[i];
            }
        }
        if(noOfDays>days)
            return false;
        return true;
    }
    public static int minCapacity(int[] weights,int l,int h,int days){
        while(l<=h){
            int mid=(h)-(h-l)/2;
            if(canAllocate(weights,mid,days))
                h=mid-1;
            else
                l=mid+1;
        }
        return l;
    }
    public int shipWithinDays(int[] weights, int days) {
        int sum=0,maxVal=Integer.MIN_VALUE;
        for(int x:weights){
            sum+=x;
            maxVal=Math.max(maxVal,x);
        }
        return minCapacity(weights,maxVal,sum,days) ;   
    }
}
