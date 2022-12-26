https://leetcode.com/problems/flood-fill/description/
https://www.youtube.com/watch?v=C-2_uSRli8o&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=9

class Solution {

    public void dfs(int r,int c,int iniColor,int color,int[][] image,int[][] resImg,int[] delRow, int[] delCol){
        resImg[r][c]=color;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int row=r+delRow[i];
            int col=c+delCol[i];

            if(row>=0 && row<n && col>=0 && col<m && image[row][col]==iniColor && resImg[row][col]!=color){
                dfs(row,col,iniColor,color,image,resImg,delRow,delCol);
            }
        }
            


        }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int r=image.length;
        int c=image[0].length;
        int[][] resImg=new int[r][c];
        int iniColor=image[sr][sc];
        int[] delRow={-1,0,+1,0};
        int[] delCol={0,+1,0,-1};

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                resImg[i][j]=image[i][j];
            }
        }

        dfs(sr,sc,iniColor,color,image,resImg,delRow,delCol);

        return resImg;
    }
}
