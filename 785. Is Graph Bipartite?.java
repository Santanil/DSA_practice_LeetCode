https://leetcode.com/problems/is-graph-bipartite/description/

https://www.youtube.com/watch?v=-vu34sct1g8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=17

class Solution {
    public boolean checkBipartite(int node,int[][] graph,int[] color){
        Queue<Integer> q=new LinkedList();
        q.add(node);
        
        while(!q.isEmpty()){
            int n=q.poll();

            for(int x:graph[n]){
                if(color[x]==-1){
                    color[x]=(color[n]==1)?0:1;
                    q.add(x);
                }else if(color[x]==color[n])
                    return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!checkBipartite(i,graph,color))
                    return false;
            }
        }

        return true;
    }
}
