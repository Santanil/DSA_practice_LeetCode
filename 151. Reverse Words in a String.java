https://leetcode.com/problems/reverse-words-in-a-string/
https://www.youtube.com/watch?v=g9xgkIjfpWY


TC: O(N)
SC:O(N)
Best code according to standards:**********************************************************************

class Solution {
    public String reverseWords(String s) {
        int i=s.length()-1;
        StringBuilder ans=new StringBuilder();
        while(i>=0){
            while(i>=0 && s.charAt(i)==' ') i--;
            int j=i;
            
            if(i<0) break;
            
            while(i>=0 && s.charAt(i)!=' ') i--;
                      
            if(ans.isEmpty()){
                ans=ans.append(s.substring(i+1,j+1));
            }else{
                ans=ans.append(" "+s.substring(i+1,j+1));
            }
        }
        String str=new String(ans.toString());
        return str;
    }
}




Another self applied algo:*************************************************************************************

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder(s.trim());
        StringBuilder sb1=new StringBuilder();
        sb.append(" ");
        sb.insert(0," ");
        int i=sb.length()-2;
        while(i>=0){
            if(sb.charAt(i)==' ' && sb.charAt(i+1)!=' '){
                int x=i+1;
                while(sb.charAt(x)!=' '){
                    sb1.append(sb.charAt(x));
                    x++;
                }
                sb1.append(" ");
            }
            
            i--;
        }
        String s1=new String(sb1.toString());
        return s1.trim();
        
    }
}


Another self applied algo:*************************************************************************************

class Solution {
    public String reverseWords(String s) {
        StringBuffer sb=new StringBuffer();
        s=s.trim();
        int l=s.length();
        int i=l-1;
        while(i>=0){

            //counting taking non-space characters and defining the boundary
            int ptr1=i;
            while(i>=0 && s.charAt(i)!=' ')
                i--;
            i++;
            int ptr2=i;

            //appending space before adding new word
            sb.append(' ');

            //appending new word for end
            while(i<=ptr1){
                sb.append(s.charAt(i));
                i++;
            }
            i=ptr2-1;

            //skip extra spaces between characters
            while(i>=0 && s.charAt(i)==' ')
                i--;
        }
        return sb.toString().trim();
    }
}
