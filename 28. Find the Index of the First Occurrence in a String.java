https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/


//kmp algorithm
//TC: O(N+M), SC:O(M)
//M-> lenght of needle

class Solution {
    public int strStr(String haystack, String needle) {
        int[] lps=new int[needle.length()];
        generateLps(needle,lps);
        return kmp(haystack,needle,lps);    
    }
    public static void generateLps(String s,int[] lps){
    int i=0,j=1,l=s.length();
    while(j<l){
        while(i>0 && s.charAt(i)!=s.charAt(j)){
            i=lps[i-1];
        }
        if(s.charAt(i)==s.charAt(j))
            lps[j]=++i;
        j++;
        }
    }

    public static int kmp(String haystack, String needle, int[] lps){
        int i=0,j=0,l=haystack.length();

        while(j<l){
            while(i>0 && needle.charAt(i)!=haystack.charAt(j)){
                i=lps[i-1];
            }
            if(needle.charAt(i)==haystack.charAt(j))
                i++;
            j++;

            if(i==needle.length())
                break;
        }
        if(i==needle.length())
            return j-i;
        else
            return -1;
    }
}

// TC: O(M*N)  SC:O(1)
class Solution {
    public int strStr(String haystack, String needle) {
        int hl=haystack.length(),nl=needle.length();

        for(int i=0;i<hl;i++){
            int x=i,y=0;
            while(x<hl && y<nl && haystack.charAt(x++)==needle.charAt(y++))

            if(y==nl)
                return i;
        }
        return -1;    
    }
}
