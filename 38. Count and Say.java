https://leetcode.com/problems/count-and-say/description/
https://www.youtube.com/watch?v=VE8yEc4R6q0

class Solution {
    public StringBuilder helper(StringBuilder stb){
        int l=stb.length();
        StringBuilder s=new StringBuilder();
        int cnt=1;
        if(stb.length()==1){
            s.append("11");
            return s;
        }
        for(int i=1;i<stb.length();i++){
            if(stb.charAt(i-1)==stb.charAt(i))
                ++cnt;
            else{
                s.append(cnt);
                s.append(stb.charAt(i-1));
                cnt=1;
            }
        }
        s.append(cnt);
        s.append(stb.charAt(l-1));
        return s;
    }
    public String countAndSay(int n) {
        StringBuilder stb=new StringBuilder("1");
        for(int j=1;j<n;j++){
            stb=helper(stb);    
        }
        return stb.toString();    
    }
}
