https://leetcode.com/problems/longest-repeating-character-replacement/description/
https://www.youtube.com/watch?v=gqXU1UyA8pk

TC:O(N)
  SC:O(26)

class Solution {
    public int findMax(int[] arr){
        int max=0;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
        }
        return max;
    }
    public int characterReplacement(String s, int k) {
        int[] count=new int[26];
        int l=0,maxCount=0;
        for(int r=0;r<s.length();r++){
            count[s.charAt(r)-'A']++;

            while((r-l+1)-findMax(count)>k){
                count[s.charAt(l)-'A']--;
                l++;
            }
            maxCount=Math.max(maxCount,r-l+1);
        }
        return maxCount;
    }
}
