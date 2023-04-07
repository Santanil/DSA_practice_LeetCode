https://leetcode.com/problems/validate-binary-search-tree/description/
https://www.youtube.com/watch?v=f-sj7I5oXEI&t=507s

TC:O(N)
  SC:O(N)

class Solution {
    public boolean checkValidBST(TreeNode root, long left,long right){
        if(root==null)
            return true;
        if(!(root.val>left && root.val<right))
            return false;
        return checkValidBST(root.left,left,root.val) && checkValidBST(root.right,root.val,right);
    }
    public boolean isValidBST(TreeNode root) {
        return checkValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}
