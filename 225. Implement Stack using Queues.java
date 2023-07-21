https://leetcode.com/problems/implement-stack-using-queues/description/
https://www.youtube.com/watch?v=jDZQKzEtbYQ&t=317s

TC: O(N)
SC: O(1)
  
class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();        
    }
    
    public void push(int x) {
        q2.add(x);
        while(q1.size()>0){
            q2.add(q1.poll());
        }
        while(q2.size()>0){
            q1.add(q2.poll());
        }
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        return q1.element();
    }
    
    public boolean empty() {
        if(q1.size()>0)
            return false;
        return true;       
    }
}
