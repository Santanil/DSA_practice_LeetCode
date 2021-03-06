//895. Maximum Frequency Stack
//https://leetcode.com/problems/maximum-frequency-stack/
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0


//TC: O(N)  SC:O(N)
class FreqStack {

    Map<Integer,Integer> freq;
    Map<Integer, Stack<Integer>> freqStack;
    int maxFreq;
    
    //Constructor
    public FreqStack() {
        freq=new HashMap<>();
        freqStack=new HashMap<>();
        maxFreq=0;
    }
    
    //update frequecy of element in freqMap
    //check maxFreq and update if required 
    //if maxFreq is updated, create new stack for the freq with updated maxFreq as the key and push data
    public void push(int val) {
        int fr= freq.getOrDefault(val,0)+1;
        freq.put(val,fr);
        if(fr > maxFreq) maxFreq = fr;
        freqStack.computeIfAbsent(fr, f->new Stack()).push(val);  //lambda expression
              
    }
    
    //pop out top element from the stack stored with maxFreq as the key in freqStack mao
    //if the stack becomes empty-> decrease max frequency
    //decreament frequency of the element from freq map
    public int pop() {
        Stack<Integer> s=freqStack.get(maxFreq);
        int top=s.pop();
        if(s.isEmpty())
            maxFreq--;
        freq.put(top,freq.get(top)-1);
        return top;
    }
}
