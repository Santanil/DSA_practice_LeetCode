//103. Binary Tree Zigzag Level Order Traversal
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
//https://www.youtube.com/watch?v=3OXWEdlIGl4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=20&t=347s

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

//TC: O(N)
//SC: O(N)
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
            return res;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        boolean leftToRight=true;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> subList=new ArrayList<>();
            
            for(int i=0;i<size;i++){
                TreeNode element=q.peek();
                if(element.left!=null) q.offer(element.left);
                if(element.right!=null) q.offer(element.right);
                if(leftToRight)
                    subList.add(q.poll().val);
                else
                    subList.add(0,q.poll().val);
            }
            leftToRight=!leftToRight;
            res.add(subList);
        }
        return res;
    }
}



