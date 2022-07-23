https://leetcode.com/problems/valid-parentheses/

//TC:O(N)
//SC:O(N)  worst case when input has only opening braces

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk=new Stack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(stk.isEmpty() || stk.peek()!='(')
                    return false;
                stk.pop();
            }
            else if(s.charAt(i)=='}'){
                    if(stk.isEmpty() || stk.peek()!='{')
                        return false;
                    stk.pop();
            }
            else if(s.charAt(i)==']'){
                    if(stk.isEmpty() || stk.peek()!='[')
                        return false;
                    stk.pop();
            }
            else
                stk.push(s.charAt(i));
        }
            
        if(stk.isEmpty())
            return true;
        else
            return false;
            
    }
}
