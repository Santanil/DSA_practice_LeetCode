//9. Palindrome Number
//https://leetcode.com/problems/palindrome-number/
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0


***************************************Recursive***********************************
class Solution {
    public boolean isPalindrome(int x) {
        return x==palindrome(x,0);         
    }
    int palindrome(int num,int x){
        if(num<=0)
            return x;
        x=(x*10)+(num%10);
        num=num/10;
        return palindrome(num,x);
    }
}


*****************************Iterative********************************************

class Solution {
    public boolean isPalindrome(int x) {
        int xCopy=x,sum=0;
        while(x>0){
            sum=(sum*10)+(x%10);
            x/=10;
        }
        return xCopy==sum;
    }
}
