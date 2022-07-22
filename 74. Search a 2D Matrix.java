https://leetcode.com/problems/search-a-2d-matrix/

https://www.youtube.com/watch?v=ZYpYur0znng



Naive Approach ---------------------------------------> to iterate though all the elements of the array to check for the target
Best Approach------------------------------------------> is to make a imaginary linear array of size N*M and do a linear search on it


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length,m=matrix[0].length;
        
        int left=0,right=(n*m)-1;
        
        while(left<=right){
            int mid=(left+ (right-left)/2);
            if(matrix[mid/m][mid%m]==target)
                return true;
            if(matrix[mid/m][mid%m]<target)
                left=mid+1;
            else
                right=mid-1;
        }
        return false;
    }
}



*********************************************************************************GFG Version**********************************************************************

class Sol
{
    public static int matSearch(int mat[][], int N, int M, int X)
    {
        // your code here
        int i=0,j=M-1;
        while(i<N && j>=0){
            if(mat[i][j]==X)
                return 1;
            if(mat[i][j]>X)
                j--;
            else
                i++;
        }
        return 0;
    }
}
