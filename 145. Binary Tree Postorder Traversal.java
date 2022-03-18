//145. Binary Tree Postorder Traversal
//https://leetcode.com/problems/binary-tree-postorder-traversal/
//https://www.youtube.com/watch?v=EoAsWbO7sqg&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=9


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
//SC: O(H)  H-> height of tree 
//SC: O(N)  for skewed tree
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        postOrder(root,list);
        return list;
    }
    public void postOrder(TreeNode root,List<Integer> list){
        if(root==null)
            return;
        postOrder(root.left,list);
        postOrder(root.right,list);
        list.add(root.val);
    }
}
