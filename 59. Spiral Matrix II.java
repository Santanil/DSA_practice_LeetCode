https://leetcode.com/problems/spiral-matrix-ii/
https://www.youtube.com/watch?v=BdQ2AkaTgOA


//TC:O(N*N)

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];
        int left=0,right=n-1,top=0,bottom=n-1;
        int size=n*n;
        int num=1;
        while(num<=size){
            
            //right movement
            for(int i=left;i<=right && num<=size;i++){
                matrix[top][i]=num++;
            }
            top++;
            
            
            //downward movement
            for(int i=top;i<=bottom && num<=size;i++){
                matrix[i][right]=num++;
            }
            right--;
            
            
            //left movement
            for(int i=right;i>=left && num<=size;i--){
                matrix[bottom][i]=num++;
            }
            bottom--;
            
            
            //upward movement
            for(int i=bottom;i>=top && num<=size;i--){
                matrix[i][left]=num++;
            }
            left++;
            
        }
        return matrix;
    }
}
