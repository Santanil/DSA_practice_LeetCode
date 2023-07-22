https://leetcode.com/problems/compare-version-numbers/description/


// TC:O(N)
// SC:O(N)

class Solution {
    public static String stripLeadingZeros(String s){
        StringBuffer str=new StringBuffer(s);
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='0')
                str.deleteCharAt(i);
            else
                break;
        }
        return str.toString();
    }
    public int compareVersion(String version1, String version2) {
        String v1=version1;
        String v2=version2;
        String[] str1=v1.split("[.]",0);
        String[] str2=v2.split("[.]",0);
        for(int i=0;i<str1.length;i++){
            if(Long.parseLong(str1[i])>0)
                stripLeadingZeros(str1[i]);
        }
        for(int i=0;i<str2.length;i++){
            if(Long.parseLong(str2[i])>0)
                stripLeadingZeros(str2[i]);
        }
        
        int i=0;
        while(i<str1.length && i<str2.length){
            long ver1=Long.parseLong(str1[i]);
            long ver2=Long.parseLong(str2[i]);
            if(ver1>ver2)
                return 1;
            else if(ver1<ver2)
                return -1;
            i++;
        }
        if(str1.length>str2.length){
            while(i<str1.length){
                if(Long.parseLong(str1[i++])>0)
                    return 1;
            }
        }else if(str1.length<str2.length){
            while(i<str2.length){
                if(Long.parseLong(str2[i++])>0)
                    return -1;
            }    
        }


        return 0; 
    }
}
