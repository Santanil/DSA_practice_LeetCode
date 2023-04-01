https://leetcode.com/problems/subtree-of-another-tree/description/
https://www.youtube.com/watch?v=HdMs2Fl_I-Q&t=525s

TC:O(N)
  SC:O(N)
    
class Solution {
    public boolean check(TreeNode root1, TreeNode root2){
        if(root1==null || root2==null)
            return root1==root2;
            
        if(root1.val!=root2.val)
            return false;
        
        return check(root1.left,root2.left) && check(root1.right,root2.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)
            return false;

        if(root.val==subRoot.val && check(root,subRoot))
            return true;

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);    
    }
}
