https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
https://www.youtube.com/watch?v=U5Mw4eyUmw4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=36

class Node{
    int row;
    int col;
    int distance;
    Node(int row,int col,int distance){
        this.row=row;
        this.col=col;
        this.distance=distance;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1)
            return -1;
        Queue<Node> q=new LinkedList<>();
        int r=grid.length;
        int c=grid[0].length;
        if(r==1 && c==1)
            return 1;
        // int[] dRow={-1,0,+1,0};
        // int[] dCol={0,+1,0,-1};
        int[][] dist=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                dist[i][j]=(int) (1e9);
            }
        }

        q.add(new Node(0,0,1));
        dist[0][0]=0;
        
        while(!q.isEmpty()){
            Node n=q.poll();
            int row=n.row;
            int col=n.col;
            int dis=n.distance;
    
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int delRow=row+i;
                    int delCol=col+j;
    
                    if(delRow>=0 && delRow<r && delCol>=0 && delCol<c && grid[delRow][delCol]==0 && (dis+1)<dist[delRow][delCol]){
                        
                        dist[delRow][delCol]=dis+1;
                        if(delRow==(r-1) && delCol==(c-1))
                            return dis+1; 
                        q.add(new Node(delRow,delCol,dis+1));
                    }
                }
            }
        }
        return -1;    
    }
}
