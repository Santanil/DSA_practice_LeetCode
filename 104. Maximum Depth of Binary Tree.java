//104. Maximum Depth of Binary Tree
//https://leetcode.com/problems/maximum-depth-of-binary-tree/
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
 
 
//TC: O(N)  
//SC:O(height of the tree)   O(N) in case of skewed tree 

class Solution {
    public int maxDepth(TreeNode root) {
        int l,r;
        if(root==null)
            return 0;
        l=maxDepth(root.left);
        r=maxDepth(root.right);

        return Math.max(l,r)+1; 
    }
}


//Using Level Order Traversal method
//TC:O(N)   SC:O(N)
class Solution {
    public int maxDepth(TreeNode root) {
        int level=0;
        if(root==null)
            return level;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            level++;
            List<Integer> list=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode peekElement=q.peek();
                if(peekElement.left!=null)
                    q.add(peekElement.left);
                if(peekElement.right!=null)
                    q.add(peekElement.right);
                q.poll();
            }
        }
        return level;
    }
}


