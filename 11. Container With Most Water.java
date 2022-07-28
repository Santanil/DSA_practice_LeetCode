https://leetcode.com/problems/container-with-most-water/


Brute Force:  TC: O(n^2), SC: O(1)
class Solution {
    public int maxArea(int[] height) { 
        int res=0,water=0;
        for(int i=0;i<height.length-1;i++){
            for(int j=i;j<height.length;j++){
                water= Math.min(height[i],height[j])*Math.abs(i-j);
                res=Math.max(res,water);
            }
        }
        return res;
    }
}


-------------------------------------------------------------------Optimized-----------------------------------------------------------------------------

TC: O(N)   SC:O(1)
class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int l=0, r=n-1,maxWater=0;
        while(l<r){
            int currentMax = Math.min(height[l],height[r])*(r-l);;
            maxWater=Math.max(maxWater,currentMax);
            if(height[l]<height[r])
                l++;
            else
                r--;
        }
        return maxWater;
    }
}
