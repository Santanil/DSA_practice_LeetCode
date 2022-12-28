https://leetcode.com/problems/01-matrix/description/

class Node{
    int row;
    int col;
    int dist;
    Node(int row,int col,int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}
class Solution {
    public int[][] bfs(int n,int m,Queue<Node> q,int[][] mat,int[][] vis,int[][] distance){
        int[] delRow={-1,0,+1,0};
        int[] delCol={0,+1,0,-1};
        while(!q.isEmpty()){
            Node node=q.poll();
            int r=node.row;
            int c=node.col;
            int d=node.dist;

            //Use following code if can be travelled in all 8 directions
            // for(int i=-1;i<=1;i++){
            //     for(int j=-1;j<=1;j++){
            //         int dRow=r+i;
            //         int dCol=c+j;
            //         if(dRow>=0 && dRow<n && dCol>=0 && dCol<m && vis[dRow][dCol]==0){
            //             vis[dRow][dCol]=1;
            //             distance[dRow][dCol]=d+1;
            //         }
            //     }
            // }

            //Use following code if can be travelled in only 4 directions
            for(int i=0;i<4;i++){
                int dRow=r+delRow[i];
                int dCol=c+delCol[i];
                if(dRow>=0 && dRow<n && dCol>=0 && dCol<m && vis[dRow][dCol]==0){
                    vis[dRow][dCol]=1;
                    distance[dRow][dCol]=d+1;
                    q.add(new Node(dRow,dCol,d+1));
                }
            }
        }
        return distance;
    }
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length,m=mat[0].length;
        int[][] vis=new int[n][m];
        int[][] distance=new int[n][m];

        Queue<Node> q=new LinkedList();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    vis[i][j]=1;
                    q.add(new Node(i,j,0));
                }
            }
        }
        return bfs(n,m,q,mat,vis,distance);
    }
}
