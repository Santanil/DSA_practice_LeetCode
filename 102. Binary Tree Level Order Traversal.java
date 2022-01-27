//102. Binary Tree Level Order Traversal
//https://leetcode.com/problems/binary-tree-level-order-traversal/
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0




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

//TC:O(N) as we are travelling all the nodes
//SC:O(N) because of the queue as it will store all the nodes in worst case
//but for SC we will not consider list as it is asked as o/p
class Solution { 
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        if(root==null) 
            return list;
        Queue<TreeNode> q= new LinkedList<>();
        TreeNode levelLastNode=root,front;
        q.add(root);
        while(!q.isEmpty()){
            int levelSize=q.size();
            List<Integer> subList=new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                front=q.peek();
                if(front.left!=null)
                    q.offer(front.left);
                if(front.right!=null)
                    q.offer(front.right);
                subList.add(front.val);
                q.remove(front);
            }
            list.add(subList);
        }
        return list;
    }
}

