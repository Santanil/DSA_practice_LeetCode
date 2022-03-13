//242. Valid Anagram
//https://leetcode.com/problems/valid-anagram/
//https://www.youtube.com/watch?v=IRN1VcA8CGc
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0


//Approach 1: Using HashMap to store the count of each characters in s string and then iterating through t and checking of it exists in the hm the decrease the freq and for any one if the freq<1 remove
//TC: O(2N)  ~ O(N)
//SC: O(1)   size of hashmap will never exceed 26 as we have only 26 no of lower case alphabets
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<t.length();i++){
            char e=t.charAt(i);
            if(hm.containsKey(e)){
                if(hm.get(e)==1)
                    hm.remove(e);
                else
                    hm.put(e,hm.get(e)-1);
            }else
                return false;
        }
        return true;
    }
}


//Approach 2: keep afreq array and keep incrementing the freq of each character in s and incrementing the freq of each character in t. At the end iterate through the freq array and check of all the freq is 0 else return false
//TC: O(N)
//SC: O(26)  ~ CONSTANT SPACE
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false; 
        char[] freq=new char[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }
        for(char c:freq)
            if(c!=0)
                return false;
        return true;
    }
}
