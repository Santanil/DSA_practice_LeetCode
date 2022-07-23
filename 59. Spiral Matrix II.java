https://leetcode.com/problems/spiral-matrix-ii/
https://www.youtube.com/watch?v=BdQ2AkaTgOA


//TC:O(M*N)
//SC:O(1)

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList();
        int left=0,right=matrix[0].length-1,top=0,bottom=matrix.length-1;
        int size=matrix.length*matrix[0].length;
        
        while(result.size()<size){
            
            //right movement
            for(int i=left;i<=right && result.size()<size;i++){
                result.add(matrix[top][i]);
            }
            top++;
            
            
            //downward movement
            for(int i=top;i<=bottom && result.size()<size;i++){
                result.add(matrix[i][right]);
            }
            right--;
            
            
            //left movement
            for(int i=right;i>=left && result.size()<size;i--){
                result.add(matrix[bottom][i]);
            }
            bottom--;
            
            
            //upward movement
            for(int i=bottom;i>=top && result.size()<size;i--){
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }
}
