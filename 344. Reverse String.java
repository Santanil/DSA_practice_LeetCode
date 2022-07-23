https://leetcode.com/problems/reverse-string/


TC: O(N/2) ~ O(N)
sc: o(1)
  
******************************************************************************************************************  
class Solution {
    public void reverseString(char[] s) {
        int n=s.length;
        for(int i=0;i<n/2;i++){
            char temp=s[i];
            s[i]=s[n-1-i];
            s[n-1-i]=temp;
        }
    }
}

*******************************************************************************************************************

class Solution {
    public void reverseString(char[] s) {
        int left=0, right=s.length-1;
        while(left<right){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }
}
