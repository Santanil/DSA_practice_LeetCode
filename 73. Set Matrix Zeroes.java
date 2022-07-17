https://leetcode.com/problems/set-matrix-zeroes/


Keeping one array to store column array that contains 1 corresponding to the column where we find 0 in the actual array
& one array to store row array that contains 1 corresponding to the column where we find 0 in the actual array.

 Now after iterating through the matrix completely, row and column arrays store the column and row for which we need to mark as 0
 Next we iterate through the matrix once again to check if the row or colmn value=1 , we update corresponding array element to 1 else we move on.

TC: O(N^2)  SC:O(max(M,N))
class Solution {
    public void setZeroes(int[][] matrix) {
        int[] row=new int[matrix.length];
        int[] column=new int[matrix[0].length];
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    row[i]=1;
                    column[j]=1;
                }
            }
        }
        for(int i=0;i<row.length;i++){
            for(int j=0;j<column.length;j++){
                if(row[i]==1 || column[j]==1)
                    matrix[i][j]=0;
            }
        }
    }
}

---------------------------------------------------------Optimized----------------------------------------


TC:O(M*N)  SC:O(1)
class Solution {
    public void setZeroes(int[][] matrix) {
        Boolean fr=false,fc=false;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    if(i==0) fr=true;
                    if(j==0) fc=true;
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0)
                    matrix[i][j]=0;
            }
        }
        if(fr){
            for(int j=0;j<matrix[0].length;j++)
                matrix[0][j]=0;
        }
        if(fc){
            for(int i=0;i<matrix.length;i++)
                matrix[i][0]=0;
        }
        
    }
}
