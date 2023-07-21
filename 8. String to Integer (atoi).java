https://leetcode.com/problems/string-to-integer-atoi/description/
https://www.youtube.com/watch?v=qZoFJKyHQ98


class Solution {
    public boolean isDigit(char c){
        if(c=='0' || c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9')
            return true;
        return false;
    }
    public int myAtoi(String s) {
        s=s.trim();
        int i=0,x=0,sign=1,l=s.length();
        if(l==0)
            return 0;
        long res=0;
        if(s.charAt(0)=='-'){
            sign=-1;
            i=1;
        }
        if(s.charAt(0)=='+')
            i=1;
        while(i<l){
            char c=s.charAt(i);
            if(!isDigit(c))
                break;
            else{
                res=(res*10)+(c-'0');
                if(sign==1 && res>Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                if(sign==-1 && (res*-1)<(Integer.MIN_VALUE))
                    return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int)res * sign;
    }
}
