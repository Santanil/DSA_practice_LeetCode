https://leetcode.com/problems/find-eventual-safe-states/description/

https://www.youtube.com/watch?v=uRbJ1OF9aYM&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=19

******DFS Technique***** (Using Recursion)
  
  class Solution {

    public boolean checkDfs(int node,int[] vis,int[] pathVis,int[] check,int[][] graph){

        vis[node]=1;
        pathVis[node]=1;
        check[node]=0;

        for(int x:graph[node]){
            if(vis[x]==0){
                if(checkDfs(x,vis,pathVis,check,graph)==true)
                    return true;
            }else if(pathVis[x]==1)
                return true;
        }
        pathVis[node]=0;
        check[node]=1;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int[] vis=new int[n];
        int[] pathVis=new int[n];
        int[] check=new int[n];
        List<Integer> safeNode=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(vis[i]==0){
                checkDfs(i,vis,pathVis,check,graph);
            }
        }

        for(int i=0;i<n;i++){
            if(check[i]==1)
                safeNode.add(i);
        }

        return safeNode;
    }
}



***************************usinf Toposort (BFS)********************************

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res=new ArrayList<>();
        List<List<Integer>> adjRev=new ArrayList<>();
        int n=graph.length;
        int[] indegree=new int[n];
        for(int i=0;i<n;i++)
            adjRev.add(new ArrayList<Integer>());

        for(int i=0;i<n;i++){

            for(int x:graph[i]){
                adjRev.get(x).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                res.add(i);
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node=q.poll();
            for(int x:adjRev.get(node)){
                indegree[x]--;
                if(indegree[x]==0){
                    res.add(x);
                    q.add(x);
                }
            }
        }

        Collections.sort(res);

        return res;

    }
}
