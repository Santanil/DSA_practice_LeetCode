https://leetcode.com/problems/gas-station/

*************************************Naive**************************************
TC:O(N^2)
SC:O(1)
  
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        for(int i=0;i<n;i++){
            if(gas[i]>=cost[i]){
                int balance=0;
                for(int j=0;j<n;j++){
                    if(gas[(i+j)%n]+balance>=cost[(i+j)%n])
                        balance+=gas[(i+j)%n]-cost[(i+j)%n];
                    else
                        break;
                    if(j==n-1)
                        return i;
                }
            }
        }
        return -1;
    }
}


*************************************Optimized********************************

TC:O(N)
SC:O(1)
  
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum=0,buffer=0,start=0;
        for(int i=0;i<gas.length;i++)
           sum=sum+gas[i]-cost[i] ;
        if(sum<0)
            return -1;
        for(int i=0;i<gas.length;i++){
            buffer+=gas[i]-cost[i];
            if(buffer<0){
                buffer=0;
                start=i+1;
            }
        }
        return start;
    }
}
