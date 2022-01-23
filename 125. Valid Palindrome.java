//125. Valid Palindrome
//https://leetcode.com/problems/valid-palindrome/
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0

//Faster solution of the two
class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer sb=new StringBuffer();
        int i=0,j;
        while(i<s.length()){
            if(s.charAt(i)>64 && s.charAt(i)<91)
                sb.append((char) (s.charAt(i)+32));   
            else if((s.charAt(i)>96 && s.charAt(i)<123)||((s.charAt(i)>47 && s.charAt(i)<58)))
                sb.append(s.charAt(i));  
            i++;
        }
        String finalString=sb.toString();
        i=0;
        j=finalString.length()-1;
        if(j<0)
            return true;
        while(i<j){
            if(finalString.charAt(i)!=finalString.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}


// class Solution {
//     public boolean isPalindrome(String string) {
//         string = string.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
//         for(int i=0; i<(string.length()/2); i++) {
//             if(string.charAt(i) != string.charAt(string.length() - 1 - i)) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }
