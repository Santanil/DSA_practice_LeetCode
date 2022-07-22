https://leetcode.com/problems/rotate-image/

https://www.youtube.com/watch?v=SA867FvqHrM

TC:O(N^2)
SC:O(1)
  
  
class Solution {
    public void rotate(int[][] matrix) {
        int r=matrix.length,c=matrix[0].length,temp;
        for(int i=0;i<r;i++){
            for(int j=i;j<c;j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        
        for(int i=0;i<r;i++){
            for(int j=0;j<(c/2);j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[i][c-j-1];
                matrix[i][c-j-1]=temp;
            }
        }
        
    }
}
