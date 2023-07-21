https://leetcode.com/problems/powx-n/description/
https://www.youtube.com/watch?v=l0YC3876qxg&t=233s

class Solution {
    public double myPow(double x, int n) {
        double res=1.0;
        if(n==0 || x==1)
            return res;
        long pow=n; 
        if(pow<0)
            pow=pow*-1;
        while(pow>0){
            if(pow%2==1){
                res= res* x;
                pow--;
            }else{
                x=x*x;
                pow=pow/2;
            }
        }
        if(n<0)
            res= (double) (1.0)/ (double) (res);
        return res;    
    }
}






// TC: O(N)
// SC: O(1)
class Solution {
    public double myPow(double x, int n) {
        double res=1.0;
        if(n==0 || x==1)
            return res;
        long pow=n;  //----> this should be taken as long as int boundary -2147483648 to 2147483647
                     //   ------------------------------------> -2147483648*-1= 2147483648>2147483647 so will overflow
        if(pow<0)
            pow=pow*-1;
        while(pow>0){
            res= res* x;
            pow--;
        }
        if(n<0)
            res= (double) (1.0)/ (double) (res);
        return res;    
    }
}
