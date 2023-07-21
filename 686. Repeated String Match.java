https://leetcode.com/problems/repeated-string-match/description/


class Solution {
    public int repeatedStringMatch(String a, String b) {
        int i=2;
        StringBuilder stb=new StringBuilder(a);
        if(b.length()==0)
            return 0;
        if(a.contains(b))
            return 1;
        while(stb.length()<=(b.length()+a.length())){
            stb.append(a);
            if(stb.indexOf(b)!=-1)
                return i;
            i++;
        }
        return -1;
    }
}
