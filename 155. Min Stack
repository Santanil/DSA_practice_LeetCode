//155. Min Stack
//https://leetcode.com/problems/min-stack/
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0

//TC: O(N)  SC:O(2N)
class MinStack {
    
    Stack<Integer> stk=new Stack<Integer>();
    Stack<Integer> min_stk=new Stack<Integer>();
    
    //constructor
    public MinStack() {
            
     }
    
    public void push(int val) {
        if(stk.isEmpty() || val<min_stk.peek()){
            min_stk.push(val);
            stk.push(val);
        }else{
            min_stk.push(min_stk.peek());
            stk.push(val);
        }
    }
    
    public void pop() {
        min_stk.pop();
        stk.pop();       
    }
    
    public int top() {
        return stk.peek();    
    }
    
    public int getMin() {
        return min_stk.peek();    
    }
    
}

//TC: O(N)  SC:O(1)
class MinStack {
    Stack<Long> st = new Stack<Long>();
    Long mini; 

    /** initialize your data structure here. */
    public MinStack() {
        mini = Long.MAX_VALUE; 
    }
    
    public void push(int value) {
        Long val = Long.valueOf(value); 
        if(st.isEmpty()) {
            mini = val; 
            st.push(val); 
        }
        else {
            if(val < mini) {
                st.push(2*val - mini); 
                mini = val; 
            }
            else {
                st.push(val); 
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return; 
        
        Long val = st.pop(); 
        if(val < mini) {
            mini = 2 * mini - val; 
        }
    }
    
    public int top() {
        Long val = st.peek(); 
        if(val < mini) {
            return mini.intValue(); 
        }
        return val.intValue(); 
    }
    
    public int getMin() {
        return mini.intValue(); 
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
