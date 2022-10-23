https://leetcode.com/problems/fibonacci-number/

https://www.youtube.com/watch?v=UxICsjrdlJA


class Solution {
    public int fib(int n) {
        if(n<2)
            return n;
        return fib(n-1)+fib(n-2);
    }
}

/**************************************Memoization*****************************************/

class Solution {
    public int calculateFib(int n,int[] mem){
        if(n<2)
            return n;
        if(mem[n]!=-1)
            return mem[n];
        mem[n]=calculateFib(n-1,mem)+calculateFib(n-2,mem);
        return mem[n];
    }
    public int fib(int n) {
        int[] arr=new int[31];
        Arrays.fill(arr,-1);
        return calculateFib(n,arr);    
    }
}
