https://leetcode.com/problems/daily-temperatures/description/

TC: O(N)
SC: O(N)
class Solution {
    public int[] dailyTemperatures(int[] t) {
        Stack<Integer> stk=new Stack<>();
        int[] res=new int[t.length];

        stk.push(0);
        for(int i=1;i<t.length;i++){
            while(!stk.isEmpty() && t[stk.peek()]<t[i]){
                res[stk.peek()]=i-stk.peek();
                stk.pop();
            }
            stk.push(i);
        }
        return res;
    }
}
