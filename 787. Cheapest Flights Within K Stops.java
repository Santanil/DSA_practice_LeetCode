https://leetcode.com/problems/cheapest-flights-within-k-stops/
https://www.youtube.com/watch?v=9XybHVqTHcQ&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=38

TC: O(E log V)
SC: O(V)

class Pair{
    int to;
    int price;
    Pair(int to,int price){
        this.to=to;
        this.price=price;
    }
}
class Element{
    int stops;
    int node;
    int price;
    Element(int stops,int node,int price){
        this.stops=stops;
        this.node=node;
        this.price=price;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<flights.length;i++)
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));

        Queue<Element> q=new LinkedList<Element>();
        int[] costArr=new int[n];
        for(int i=0;i<n;i++)
            costArr[i]=(int) (1e9);

        q.add(new Element(0,src,0));
        costArr[src]=0;

        while(!q.isEmpty()){
            Element e=q.poll();
            int stop=e.stops;
            int curNode=e.node;
            int pr=e.price;

            if(stop>k) continue;
            for(Pair x:adj.get(curNode)){
                 int nextNode=x.to;
                 int cost=x.price;

                 if(cost+pr<costArr[nextNode] && stop<=k){
                     q.add(new Element(stop+1,nextNode,cost+pr));
                     costArr[nextNode]=cost+pr;
                 }
            }
        }

        if(costArr[dst]==(1e9))
            return -1;
        return costArr[dst];
    }
}
