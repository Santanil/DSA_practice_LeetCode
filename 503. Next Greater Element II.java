https://leetcode.com/problems/next-greater-element-ii/

https://www.youtube.com/watch?v=Du881K7Jtk8&t=923s



TC:O(2n+2n) ~ O(n)  //because inner loop will not run n times. Both will in total run 2n number of times
SC:O(1)
  
  
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk=new Stack<>();
        int n=nums.length;
        int[] nge=new int[n];
        
        for(int i=(2*n)-1;i>=0;i--){
            while(!stk.isEmpty() && stk.peek()<=nums[i%n])   // '=' in <= is imp
                stk.pop();
            
            if(i<n){
                if(!stk.isEmpty())
                    nge[i]=stk.peek();
                else
                    nge[i]=-1;
            }
            
            stk.push(nums[i%n]);
        }
        return nge;
    }
}


