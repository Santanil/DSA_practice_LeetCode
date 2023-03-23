https://leetcode.com/problems/sum-of-two-integers/description/
https://www.youtube.com/watch?v=gVUrDV4tZfY&t=505s


TC: ?
SC: O(1)
class Solution {
    public int getSum(int a, int b) {
        int xor=a^b;
        int and=a&b;
        //when there is no carry
        if(and==0)
            return xor;
        
        //when there is carry
        while(and!=0){
            and= and<<1;
            int temp=xor;
            xor=xor^and;
            and=temp&and;
        }

        return xor;    
    }
}
