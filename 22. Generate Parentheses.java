//22. Generate Parentheses
//https://leetcode.com/problems/generate-parentheses/
//https://www.youtube.com/watch?v=R6RddNeX3ug 
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0


//TC:O(N)  SC:O(N)
class Solution {
    
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        findList("(",1,0,ans,n);
        return ans;
    }
    
    public void findList(String current,int o,int c,List<String> ans,int n){
        
        //base case
        if(current.length()==2*n){
            ans.add(current);
            return;
        }
        
        if(o<n)
            findList(current+"(",o+1,c,ans,n);
        if(c<o)
            findList(current+")",o,c+1,ans,n);
    }
}
