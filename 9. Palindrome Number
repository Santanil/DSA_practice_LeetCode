//9. Palindrome Number
//https://leetcode.com/problems/palindrome-number/
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0

class Solution {
    public boolean isPalindrome(int x) {
        int xCopy=x,num=0,i=0;
        if(x<0)
            return false;
        while(x!=0){
            num=(num*10)+x%10;
            x=x/10;
            i++;
        }
        if(num==xCopy)
            return true;
        else
            return false;
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        int num=0;
        if(x<0 || (x != 0 && x % 10 == 0))
            return false;
        while(x>num){
            num=(num*10)+x%10;
            x=x/10;
        }
        return (x==num || x==num/10);
    }
}
