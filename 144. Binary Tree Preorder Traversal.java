//144. Binary Tree Preorder Traversal
//https://leetcode.com/problems/binary-tree-preorder-traversal/
recursive->//https://www.youtube.com/watch?v=RlUu72JrOCQ&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=6
iterative->//https://www.youtube.com/watch?v=Bfqd8BsPVuw&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=10
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
//TC: O(N) where N is the no. of nodes in the tree
//SC: O(H) where H is the height of the tree
//In case of skewed tree  SC:O(N)
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        preorder(root,list);
        return list;
    }
    public void preorder(TreeNode root,List<Integer> list){
        if(root==null)
            return;
        list.add(root.val);
        preorder(root.left,list);
        preorder(root.right,list);
    }
}


//Iterative Method
//TC: O(N)
//SC: O(N) for stack
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null)
            return list;
        Stack<TreeNode> s=new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode top=s.pop();
            list.add(top.val);
            if(top.right!=null) s.push(top.right);
            if(top.left!=null) s.push(top.left);
        }
        return list;  
    }
}
