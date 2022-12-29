https://leetcode.com/problems/course-schedule-ii/description/
https://www.youtube.com/watch?v=WAOfKpxYHR8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=23


class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int[] orderedTasks=new int[numCourses];
        //forming adjacency list
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<Integer>()); 
        for(int i=0;i<prerequisites.length;i++)
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);

        int cnt=0;  
        int[] indegree=new int[numCourses];
        Queue<Integer> q=new LinkedList<>();
        
        //Update Indegree array
        for(int i=0;i<numCourses;i++){
            for(int x:adj.get(i))
                indegree[x]++;
        }
        
        //Add nodes with indegree 0 to the queue
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        
        //iterate on q and update indegree and keep adding nodes with indegree 0 to the queue
        while(!q.isEmpty()){
            int top=q.poll();
            orderedTasks[cnt++]=top;
            for(int x:adj.get(top)){
                indegree[x]--;
                if(indegree[x]==0)
                    q.add(x);
            }
        }
        int i=0,l=orderedTasks.length;
        while(i<l){
            int temp=orderedTasks[i];
            orderedTasks[i]=orderedTasks[l-1];
            orderedTasks[l-1]=temp;
            i++;
            l--;
        }
        if(cnt==numCourses)
            return orderedTasks;
        return new int[]{};    
    }
}
