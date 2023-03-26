BF:

Generate all sibstrings and compare

TC: O(N^3)  SC:O(N)
  
  
  
***********************************************Better Sol******************************************************
TC:O(2N)  SC:(N)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs=new HashSet<>();
        int l=0,r=0,len=s.length(),res=0;
        while(r<len){
            char c=s.charAt(r);
            if(hs.contains(c)){
                hs.remove(s.charAt(l));
                l++;
            }else{
                hs.add(c);
                res=Math.max(res,r-l+1);
                r++;
            }
            
        }
        return res;    
    }
}


***********************************************Best Sol******************************************************
TC:O(N)  SC:(N)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        int left=0,right=0,maxLen=0;
        while(right<s.length()){
            char c=s.charAt(right);
            if(hm.containsKey(c) && hm.get(c)>=left)
                left=hm.get(c)+1;
            hm.put(c,right);
            maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;    
    }
}
