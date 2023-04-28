https://leetcode.com/problems/longest-common-prefix/description/


TC: O(N^2)
  SC: O(1)  //cnsidering SC of the result to be returned not to be considered
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder str=new StringBuilder();
        for(int i=0;i<strs[0].length();i++){
            char c=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(i>=strs[j].length() || strs[j].charAt(i)!=c)
                    return str.toString();
            }
            str.append(c);
        }
        return str.toString();    
    }
}

--------------------------------------------------------------------------------------
  
  
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder str=new StringBuilder();
        Arrays.sort(strs);
        String first=strs[0];
        String  last=strs[strs.length-1];

        for(int i=0;i<strs[0].length();i++){
            if(first.charAt(i)==last.charAt(i))
                str.append(first.charAt(i));
            else
                break;
        }
        return str.toString();
    }
}

