https://leetcode.com/problems/surrounded-regions/description/
https://www.youtube.com/watch?v=BtdgAys4yMk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=14

class Pair{
    int row,col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}

class Solution {
    public void bfs(int row,int col,int n,int m,int[][] vis,char[][] board){
        int[] delRow={-1,0,+1,0};
        int[] delCol={0,+1,0,-1};
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(row,col));
        vis[row][col]=1;
        while(!q.isEmpty()){
            Pair pair=q.poll();
            int r=pair.row;
            int c=pair.col;

            for(int i=0;i<4;i++){
                int dRow=r+delRow[i];
                int dCol=c+delCol[i];

                if(dRow>=0 && dRow<n && dCol>=0 && dCol<m && vis[dRow][dCol]==0 && board[dRow][dCol]=='O'){
                    vis[dRow][dCol]=1;
                    q.add(new Pair(dRow,dCol));
                }
            }
        }
    }

    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] vis=new int[n][m];

        //check for top row
        for(int c=0;c<m;c++){
            if(board[0][c]=='O'){
                bfs(0,c,n,m,vis,board);
            }
        }

        //check for last row
        for(int c=0;c<m;c++){
            if(board[n-1][c]=='O'){
                bfs(n-1,c,n,m,vis,board);
            }
        } 

        //check for first col
        for(int r=0;r<n;r++){
            if(board[r][0]=='O'){
                bfs(r,0,n,m,vis,board);
            }
        } 

        //check for last col
        for(int r=0;r<n;r++){
            if(board[r][m-1]=='O'){
                bfs(r,m-1,n,m,vis,board);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && vis[i][j]==0)
                    board[i][j]='X';
            }
        }       
    }
}
