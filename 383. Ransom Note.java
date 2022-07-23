https://leetcode.com/problems/ransom-note/


//TC: O(N)
//SC: O(N)
class Solution {
    public boolean canConstruct(String ransomeNote, String magazine) {
        HashMap<Character,Integer> hm=new HashMap();
        int charCount=0;
        //inserting characters of ransomnote into HashMap
        for(int i=0;i<magazine.length();i++){
            if(hm.containsKey(magazine.charAt(i)))
                hm.put(magazine.charAt(i), hm.get(magazine.charAt(i))+1);
            else
                hm.put(magazine.charAt(i),1);
        }
        
        
        for(int i=0;i<ransomeNote.length();i++){
            if(hm.containsKey(ransomeNote.charAt(i))){
                charCount=hm.get(ransomeNote.charAt(i));
                if(charCount==1)
                    hm.remove(ransomeNote.charAt(i));
                else
                    hm.put(ransomeNote.charAt(i),--charCount);
                    
            }else
                return false;
        }
        
        return true;
    }
}
