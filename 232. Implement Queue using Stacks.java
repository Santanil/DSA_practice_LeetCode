https://leetcode.com/problems/implement-queue-using-stacks/description/
https://www.youtube.com/watch?v=3Et9MrMc02A


TC: O(1)   ------> Amotized O(1) in almost all the cases
SC: O(2N)

class MyQueue {
    Stack<Integer> stk1;
    Stack<Integer> stk2;
    public MyQueue() {
        stk1=new Stack<>(); 
        stk2=new Stack<>();   
    }
    
    public void push(int x) {
        stk1.push(x);
    }
    
    public int pop() {
        if(stk2.isEmpty()){
            while(!stk1.isEmpty()){
                stk2.push(stk1.pop());
            }    
        }
        return stk2.pop();    
    }
    
    public int peek() {
        if(stk2.isEmpty()){
            while(!stk1.isEmpty()){
                stk2.push(stk1.pop());
            }    
        }
        return stk2.peek();    
    }
    
    public boolean empty() {
        return stk1.isEmpty() && stk2.isEmpty();    
    }
}
