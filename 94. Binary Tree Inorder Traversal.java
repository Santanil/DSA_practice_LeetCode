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
//TC: O(N)  SC: O(H)  H- height of the tree
class Solution {
    public List<Integer> inorder(TreeNode root, List l){
        if(root==null)
            return l;
        inorder(root.left,l);
        l.add(root.val);
        inorder(root.right,l);
        return l;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>()    ;
        res=inorder(root,res);
        return res;
    }
}


//Morris Traversal
//TC:O(N)   SC:O(1)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder=new ArrayList<>()    ;
        TreeNode cur=root;
        while(cur!=null){
            if(cur.left==null){  //don't have left node so add the current root node and move right
                inorder.add(cur.val);
                cur=cur.right;
            }else{
                TreeNode prev=cur.left;
                while(prev.right!=null && prev.right!=cur){ //move to the right most node of the left subtree of the cur node
                    prev=prev.right;
                }
                
                if(prev.right==null){ //if the right of the rightmost node ==null then create a thread to node
                    prev.right=cur;
                    cur=cur.left;
                }else{  // thread exist so destroy it and add the cur root value and then move right
                    prev.right=null;
                    inorder.add(cur.val);
                    cur=cur.right;
                }
            }
        }
        return inorder;
    }
}
