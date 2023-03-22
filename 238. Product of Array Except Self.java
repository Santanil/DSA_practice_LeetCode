https://leetcode.com/problems/product-of-array-except-self/description/
https://www.youtube.com/watch?v=bNvIQI2wAjk

TC:O(N)
  SC:(N)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l=nums.length;
        int[] pre=new int[l];
        int[] post=new int[l];
        int[] res=new int[l];
        int x=1;
        for(int i=0;i<l;i++){
            pre[i]=x*nums[i];
            x=pre[i];
        }
        x=1;
        for(int i=l-1;i>=0;i--){
            post[i]=x*nums[i];
            x=post[i];
        }
        res[0]=post[1];
        res[l-1]=pre[l-2];
        for(int i=1;i<l-1;i++)
            res[i]=pre[i-1]*post[i+1];

        return res;
    }
}

-------------------------------Space Optimized---------------------------------

  TC:O(N)
    SC: O(1)
      
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l=nums.length;
        int[] res=new int[l];    

        int pre=1;
        for(int i=0;i<l;i++){
            res[i]=pre;
            pre*=nums[i];
        }

        int post=1;
        for(int i=l-1;i>=0;i--){
            res[i]*=post;
            post*=nums[i];
        }
        return res;
    }
}
