https://leetcode.com/problems/plus-one/

https://www.youtube.com/watch?v=G737jzcxG9A


Solution 1
TC:O(N)   SC:O(N)
class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> list=new ArrayList();
        int sum=1,carry=0;
        for(int i=digits.length-1;i>=0;i--){
            sum+=digits[i]+carry;
            if(sum<10)
                carry=0;
            else{
                carry=sum-9;
                sum-=10;
            }
            list.add(sum);
            sum=0;
        }
        if(carry!=0)
            list.add(carry);
        int[] res=new int[list.size()];
        for(int i=list.size()-1;i>=0;i--)
            res[list.size()-i-1]=list.get(i);
        return res;
    }
}

------------------------------------------------------------------------------------------------------------------------------------------------
  
  
Optimized Solution 

TC: O(N)  SC:O(1)
class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        for(int i=n-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        
        int[] newNum=new int[n + 1];
        newNum[0]=1;
        return newNum;
    }
}
