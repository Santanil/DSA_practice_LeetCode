//326. Power of Three
//https://leetcode.com/problems/power-of-three/
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0
//https://www.youtube.com/watch?v=UncqP2F4t_0


//Iterative
//TC: O(log N base 3)  SC:O(1)
class Solution {
    public boolean isPowerOfThree(int n) {
        while(n>=3){
            if(n%3 != 0) return false;
            n/=3;
        }
        return n==1;
    }
}

//Recursive
//TC:O(log N base 3)  SC:O(log N base 3)
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n==1)
            return true;
        if(n<3 || n%3!=0)
            return false;
        if(isPowerOfThree(n/3)==true)
            return true;
        else
            return false;
    }
}

//Recursive shortened code
//TC:O(log N base 3)  SC:O(log N base 3)
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=1) return n==1;
        return n%3==0 && isPowerOfThree(n/3);
    }
}
