https://leetcode.com/problems/assign-cookies/

TC: O(NlogN)
SC: O(1)

class Solution{
    public int findContentChildren(int[] g, int[] s) {
        int count=0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j=0;
        for(int i=0; i<g.length; i++){
            while(j<s.length && s[j]<g[i]) j++;
            if(j==s.length) break;
            count++;
            j++;
        }
        return count;
    }
}
