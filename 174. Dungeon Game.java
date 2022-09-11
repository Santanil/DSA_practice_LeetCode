DP2
https://leetcode.com/problems/dungeon-game/

class Solution {
    public int calculateMinimumHP(int[][] A) {
        int r=A.length,c=A[0].length;
        int[][] temp=new int[r][c];

        for(int i=r-1;i>=0;i--){
            for(int j=c-1;j>=0;j--){
                if((i==r-1) && (j==c-1)){
                    if(A[i][j]>=0)
                        temp[i][j]=1;
                    else
                        temp[i][j]=(A[i][j]*-1)+1;
                }
                else if(i==r-1)
                    temp[i][j]=Math.max(1,temp[i][j+1]-A[i][j]);
                else if(j==c-1)
                    temp[i][j]=Math.max(1,temp[i+1][j]-A[i][j]);
                else
                    temp[i][j]=Math.max(1, Math.min(temp[i+1][j],temp[i][j+1])-A[i][j] );
            }
        }
        return temp[0][0];    
    }
}
