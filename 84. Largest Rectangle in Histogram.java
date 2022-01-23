//84. Largest Rectangle in Histogram
//https://leetcode.com/problems/largest-rectangle-in-histogram/
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0
//https://www.youtube.com/watch?v=X0X6G-eWgQ8&t=38s

TC: O(N^2)  SC: O(1)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            int minHeight=heights[i];
            for(int j=i;j<heights.length;j++){
                if(heights[j]<minHeight)
                    minHeight=heights[j];
                maxArea=Math.max(maxArea,(j-i+1)*minHeight);
                System.out.print(maxArea+" ");
                System.out.print((j-i+1)*minHeight+"  ");
            }
        }
        return maxArea;
    }
}


// TC: O(N)   SC: O(N)
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk=new Stack<>();
        int l=heights.length,maxArea=0;
        int[] leftSmaller=new int[l];
        int[] rightSmaller=new int[l];
        
        //computing left smaller
        for(int i=0;i<l;i++){
            while(!stk.isEmpty() && heights[stk.peek()]>=heights[i])
                stk.pop();
            if(stk.isEmpty())
                leftSmaller[i]=0;
            else
                leftSmaller[i]=stk.peek()+1;
            
            stk.push(i);
        }
        
        // clear the stack to be re-used
        while(!stk.isEmpty()) stk.pop();
        
        
        //computing right smaller
        for(int i= l-1;i>=0;i--) {
            while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                stk.pop(); 
            }
            
            if(stk.isEmpty()) 
                rightSmaller[i] = l-1; 
            else 
                rightSmaller[i] = stk.peek() - 1;
            
            stk.push(i); 
        }
        
        
        for(int i=0;i<l;i++){
            maxArea=Math.max(maxArea, (rightSmaller[i]-leftSmaller[i]+1) * heights[i]); 
        }
        
           return maxArea;
        }
  }
  
