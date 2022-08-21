
https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

https://www.youtube.com/watch?v=Et9OCDNvJ78&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=23

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Tuple{
    TreeNode node;
    int row;
    int col;
    Tuple(TreeNode node, int row, int col){
        this.node=node;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap();
        Queue<Tuple> q=new LinkedList();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple tuple=q.poll();
            TreeNode node=tuple.node;
            int x=tuple.row;
            int y=tuple.col;
            
            if(!map.containsKey(x))
                map.put(x, new TreeMap<>());
            
            if(!map.get(x).containsKey(y))
                map.get(x).put(y, new PriorityQueue<>());
            
            map.get(x).get(y).offer(node.val);
            
            if(node.left!=null)
                q.offer(new Tuple(node.left,x-1,y+1));
            if(node.right!=null)
                q.offer(new Tuple(node.right,x+1,y+1));
            
        }
        List<List<Integer>> list=new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> tm: map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> node: tm.values()){
                while(!node.isEmpty())
                    list.get(list.size()-1).add(node.poll());
            }
        }
            
        return list;
    }
}

