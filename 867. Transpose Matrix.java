//867. Transpose Matrix
//https://leetcode.com/problems/transpose-matrix/
//https://www.youtube.com/watch?v=VDw9y6nX_ss
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0

class Solution {
    public int[][] transpose(int[][] a) {
        int row=a.length;
        int col=a[0].length;
        int[][] matrix=new int[col][row];
        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){
                matrix[i][j]=a[j][i];
            }
        }
        return matrix;
    }
}
