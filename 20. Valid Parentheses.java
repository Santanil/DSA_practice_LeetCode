https://leetcode.com/problems/valid-parentheses/

//TC:O(N)
//SC:O(N)  worst case when input has only opening braces

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            
            if(c=='(' || c=='{' || c=='[')
                stk.push(c);
            else{
                if(stk.isEmpty())
                    return false;
                if((c==')' && stk.peek()=='(') || (c=='}' && stk.peek()=='{') || (c==']' && stk.peek()=='['))
                    stk.pop();
                else
                    return false;
            }
        }
        if(stk.isEmpty())
            return true;
        return false;
    }
}



