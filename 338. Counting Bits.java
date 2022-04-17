338. Counting Bits
https://leetcode.com/problems/counting-bits/


-------------------------BF------------------------------
//TC:O(32N)  for 32bit representaion
//SC:O(1)
class Solution {
    public int[] countBits(int n) {
        int[] res=new int[n+1];
        res[0]=0;
        for(int i=1;i<=n;i++){
            int sum=0,num=i;
            while(num!=0){
                if(num%2==1)
                    sum++;
                num=num/2;
            }
            res[i]=sum;
        }
        return res;
    }
}


-------------------------Optimized------------------------------
//TC: O(n)  SC: O(1)

class Solution {
    public int[] countBits(int n) {
        int res[]= new int[n+1];
        res[0]=0;
        for(int i=1;i<=n;i++)
            res[i]=res[i/2]+ i%2;

        return res;
    }
}
