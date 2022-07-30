https://leetcode.com/problems/evaluate-reverse-polish-notation/


TC: O(N)
SC: O(N)
  
  
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        
        String operator = "+-*/";
        for(String token : tokens)
        {
            if(!operator.contains(token))
            {
                stack.push(Integer.valueOf(token));
            }
            else
            {
                int number2 = stack.pop();
                int number1 = stack.pop();
                
                int result = calculate(number1, number2, token);
                stack.push(result);
            }
        }
        return stack.pop();
    }
    
    public int calculate(int number1, int number2, String token)
    {
        int result = 0;
        
        switch(token) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
        }
        return result;
    }
}
