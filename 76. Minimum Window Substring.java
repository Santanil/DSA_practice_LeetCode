https://leetcode.com/problems/minimum-window-substring/description/
https://www.youtube.com/watch?v=jSto0O4AJbM&t=426s


TC: O(N)
  SC:O(N)
    
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> req=new HashMap<>();
        HashMap<Character,Integer> cur=new HashMap<>();
        String str="";
        int minLen=Integer.MAX_VALUE;
        long have=0,need=0;
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            if(req.containsKey(c))
                req.put(c,req.get(c)+1);
            else{
                req.put(c,1);
                need++;
            }
        }

        int left=0,right=0;
        while(right<s.length()){
            char c=s.charAt(right);
            if(cur.containsKey(c))
                cur.put(c,cur.get(c)+1);
            else
                cur.put(c,1);
            
            
            //This happens due to integer caching done by java. The last test case causes the
            //character counts to go above 128 and thus == doesn’t work as expected. You can use
            //equals() for comparing Integer objects or use intValue to unbox it into a primitive int.

            //check if this meets any condition
            if(req.containsKey(c) && req.get(c).equals(cur.get(c)))
                have++;
            //once all conditions are meet keep removing eleemnts from left until condition remains 
            //valid to find minLen
            while(left<=right && need==have){
                if(minLen>=right-left+1){    
                    minLen=right-left+1;
                    str=s.substring(left,right+1);
                }
                char x=s.charAt(left);
                if(req.containsKey(x) && (cur.get(x)-1)<req.get(x))
                    have--;
                if(cur.get(x)==1)
                    cur.remove(x);
                else
                    cur.put(x,cur.get(x)-1);
                left++;
            }
            right++;
        }
        return str;       
    }
}
