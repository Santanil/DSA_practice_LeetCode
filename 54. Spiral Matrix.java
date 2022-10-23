https://leetcode.com/problems/spiral-matrix/
https://www.youtube.com/watch?v=BdQ2AkaTgOA

//TC:O(M*N)
//SC:O(1)

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> list=new ArrayList<>();
        int l=0,r=matrix[0].length-1,d=matrix.length-1,u=0;
        int n=(r+1)*(d+1);
        
        while(n>0){   // not >=, keep in mind
            
            //right
            int r1=l;
            while(n>0 && r1<=r){
                list.add(matrix[u][r1++]);
                n--;
            }u++;
            
            //down
            int d1=u;
            while(n>0 && d1<=d){
                list.add(matrix[d1++][r]);
                n--;
            }r--;
            
            //left
            int l1=r;
            while(n>0 && l1>=l){
                list.add(matrix[d][l1--]);
                n--;
            }d--;
            
            //up
            int u1=d;
            while(n>0 && u1>=u){
                list.add(matrix[u1--][l]);
                n--;
            }l++;   
            
        }
        return list;
               
    }
}


/***********************************Same TC but abve code is more intutive***************************************/

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

