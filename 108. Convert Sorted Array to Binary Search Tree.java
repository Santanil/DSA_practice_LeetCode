https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

https://www.youtube.com/watch?v=12omz-VAyRk

class Solution {
    public TreeNode constructBBST(int[] nums,int left, int right){
        if(left>right)
            return null;
        int mid=left+(right-left)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=constructBBST(nums,left,mid-1);
        root.right=constructBBST(nums,mid+1,right);
        
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root=constructBBST(nums,0,nums.length-1); //Balanced Binary Search Tree
        return root;
    }
}
