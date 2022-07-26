https://leetcode.com/problems/trapping-rain-water/

//TC: O(N)
//SC: O(N)

class Solution {
    public int trap(int[] height) {
        int leftMax=0,rightMax=0,n=height.length,resultAmt=0;
        if(n<2)
            return 0;
        int[] leftArr=new int[n];
        int[] rightArr=new int[n];
        
        
        //leftArr stores the max height present to its left
        for(int i=1;i<n;i++){
            leftMax=Math.max(height[i-1],leftMax);
            leftArr[i]=leftMax;
        }
        
        //rightArr stores the max height present to its right
        for(int i=n-2;i>=0;i--){
            rightMax=Math.max(height[i+1],rightMax);
            rightArr[i]=rightMax;
        }
        
        //computes the result by finding out the diff between min among the max height on both sides and its current height
        for(int i=1;i<n-1;i++){
            int capacity=Math.min(leftArr[i],rightArr[i]);
            if(capacity>height[i])
                resultAmt+=capacity-height[i];
        }
        return resultAmt;
    }
}
