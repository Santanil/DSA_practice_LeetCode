//387. First Unique Character in a String
//https://leetcode.com/problems/first-unique-character-in-a-string/
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0
//https://www.youtube.com/watch?v=ReUGo6fZafc


//TC: O(N)  SC: O(26)
class Solution {
    public int firstUniqChar(String s) {
        int[] frq=new int[26];
        for(int x:frq)
            x=0;
        for(int i=0;i<s.length();i++){
            frq[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(frq[s.charAt(i)-'a']==1)
                return i;
        }
        return -1;
    }
}

//Solution of the i/p contains any character and not limited to only lowercase letters
// TC: O(N)   SC: O(N)
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i)))
                hm.put(s.charAt(i),hm.get(s.charAt(i))+1);
            else
                hm.put(s.charAt(i),1);
        }
        for(int i=0;i<s.length();i++){
            if(hm.get(s.charAt(i))==1)
                return i;
        }
        return -1;
    }
}
