https://leetcode.com/problems/path-with-minimum-effort/description/
https://www.youtube.com/watch?v=0ytpZyiZFhA&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=37

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
    public int minimumEffortPath(int[][] grid) {
        PriorityQueue<Node> q=new PriorityQueue<Node>((x,y)->x.distance-y.distance);
        int r=grid.length;
        int c=grid[0].length;
        int[] dRow={-1,0,+1,0};
        int[] dCol={0,+1,0,-1};
        int[][] dist=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                dist[i][j]=(int) (1e9);
            }
        }

        q.add(new Node(0,0,0));
        dist[0][0]=0;
        
        while(!q.isEmpty()){
            Node n=q.poll();
            int row=n.row;
            int col=n.col;
            int dis=n.distance;
            if(row==(r-1) && col==(c-1))
                        return dis;
            for(int i=0;i<4;i++){
                int delRow=row+dRow[i];
                int delCol=col+dCol[i];
                if(delRow>=0 && delRow<r && delCol>=0 && delCol<c){
                    int d=Math.max(Math.abs(grid[delRow][delCol]-grid[row][col]),dis);
                    if(d<dist[delRow][delCol]){
                        dist[delRow][delCol]=d; 
                        q.add(new Node(delRow,delCol,d));
                    }
                }
                
            }
        }
        return -1;    
    }
}
