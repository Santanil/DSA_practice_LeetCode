https://leetcode.com/problems/trapping-rain-water/
https://www.youtube.com/watch?v=m18Hntz4go8

TC: O(N)
SC: O(N)

class Solution {
    public int trap(int[] height) {
        int l=height.length,sum=0;
        int[] leftMax=new int[l];
        int[] rightMax=new int[l];
        
        leftMax[0]=height[0];
        rightMax[l-1]=height[l-1];
        for(int i=1;i<l;i++)
            leftMax[i]=Math.max(leftMax[i-1],height[i]);
        
        for(int i=l-2;i>=0;i--)
            rightMax[i]=Math.max(rightMax[i+1],height[i]);
        
        for(int i=0;i<l;i++){
            int water=Math.min(leftMax[i],rightMax[i])-height[i];
            if(water>0)
                sum+=water;
        }
        return sum;
    }
}


---------------------------------------------------------Optimized----------------------------------------------------------
   TC: O(N)
   SC: O(1)
    
    class Solution {
    public int trap(int[] height) {
        int len=height.length;
        int i=0,l=0,r=len-1,leftMax=0,rightMax=0,water=0;
        while(l<r){
            if(height[l]<=height[r]){
                if(height[l]>=leftMax)
                    leftMax=height[l];
                else
                    water+=leftMax-height[l];
                l++;
            }else{
                if(height[r]>=rightMax)
                    rightMax=height[r];
                else
                    water+=rightMax-height[r];
                r--;
            }
            i++;
        }
        return water;
    }
}
