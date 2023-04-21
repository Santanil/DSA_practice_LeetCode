https://leetcode.com/problems/maximal-rectangle/description/
https://www.youtube.com/watch?v=tOylVCugy9k&t=1s



TC:O(N^2)
  SC:O(N)
    
    
class Solution {
    public void findLeftBoundary(int[] heights, int[] arr){
        int n=heights.length;
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && heights[i]<=heights[stk.peek()])
                stk.pop();
            if(stk.isEmpty())
                arr[i]=0;
            else
                arr[i]=stk.peek()+1;
            stk.push(i);
        }
    }
    public void findRightBoundary(int[] heights, int[] arr){
        int n=heights.length;
        Stack<Integer> stk=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && heights[i]<=heights[stk.peek()])
                stk.pop();
            if(stk.isEmpty())
                arr[i]=n-1;
            else
                arr[i]=stk.peek()-1;
            stk.push(i);
        }
    }
    public int largestRectangleArea(int[] heights) {
        int n=heights.length,res=0;
        int[] left=new int[n];    
        int[] right=new int[n];
        findLeftBoundary(heights,left);
        findRightBoundary(heights,right);

        for(int i=0;i<n;i++){
            res=Math.max(res,(right[i]-left[i]+1)*heights[i]);
        }
        return res;
    }
    public int maximalRectangle(char[][] matrix) {
        int maxArea=0;
        int[] temp=new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0')
                    temp[j]=0;
                else
                    temp[j]+=1;
            }
            maxArea=Math.max(maxArea,largestRectangleArea(temp));
        }
        return maxArea;    
    }
}
