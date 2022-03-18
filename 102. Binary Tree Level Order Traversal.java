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
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
            return res;
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode peekElement=q.peek();
                if(peekElement.left!=null)
                    q.add(peekElement.left);
                if(peekElement.right!=null)
                    q.add(peekElement.right);
                list.add(peekElement.val);
                q.poll();
            }
            res.add(list);
        }
        return res;
    }
}

//Note:
//Poll() - It will give the head element of the queue and will remove the head element from queue. If queue is empty then it will return null.

//Remove() - It will give the head element of the queue and will remove the head element from queue. If queue is empty then it will throw an Exception.


//offer vs add
//The only difference between the methods is that the OFFER method throws true or false if the addition is made. As opposed to this, 
//the ADD method throws an exception when no more additions are possible in the queue.
