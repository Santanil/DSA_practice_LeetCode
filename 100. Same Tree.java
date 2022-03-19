//100. Same Tree
//https://leetcode.com/problems/same-tree/
//https://www.youtube.com/watch?v=BhuvF_-PWS0&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=19

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

//TC:O(N)
//SC:O(H)   H=N in case of skewed tree
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        if((p==null && q!=null) || (p!=null && q==null))
            return false;
        if(p.val!=q.val)
            return false;
        
        if(!isSameTree(p.left,q.left))
            return false;
        if(!isSameTree(p.right,q.right))
            return false;
        
        return true;
    }
}

//check the coding style(same code)
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q == null) {
            return (p==q); 
        } 
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right); 
    }
}
