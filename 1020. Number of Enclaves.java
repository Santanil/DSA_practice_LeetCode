https://leetcode.com/problems/number-of-enclaves/description/

https://www.youtube.com/watch?v=rxKcepXQgU4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=15


//TC:O(n*m)
//SC:O(n*m)

class Pair{
    int row,col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public void bfs(int n,int m,Queue<Pair> q,int[][] vis,int[][] grid){
        int[] delRow={-1,0,+1,0};
        int[] delCol={0,+1,0,-1};
        while(!q.isEmpty()){
            Pair pair=q.poll();
            int r=pair.row;
            int c=pair.col;

            for(int i=0;i<4;i++){
                int dRow=r+delRow[i];
                int dCol=c+delCol[i];

                if(dRow>=0 && dRow<n && dCol>=0 && dCol<m && vis[dRow][dCol]==0 && grid[dRow][dCol]==1){
                    vis[dRow][dCol]=1;
                    q.add(new Pair(dRow,dCol));
                }
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int cnt=0;
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];

        Queue<Pair> q=new LinkedList<>();
        //check for top row
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]==1){
                        vis[i][j]=1;
                        q.add(new Pair(i,j));
                    }
                }
            }
        }
        bfs(n,m,q,vis,grid);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==0)
                    cnt++;
            }
        }
        return cnt;       
    }
}
