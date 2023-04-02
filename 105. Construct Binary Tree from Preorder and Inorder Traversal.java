https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

https://www.youtube.com/watch?v=aZNaLrVebKQ&t=963s

TC:O(n logn) -> log n for hashmap
  SC:O(n)
class Solution {
    public TreeNode constructTree(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd,HashMap<Integer,Integer> hm){
        //base case
        if(preStart>preEnd || inStart>inEnd)
            return null;
        
        TreeNode root=new TreeNode(pre[preStart]);

        int inRootPos=hm.get(pre[preStart]);
        int num=inRootPos-inStart;

        root.left=constructTree(pre,preStart+1,preStart+num,in,inStart,inRootPos-1,hm);
        root.right=constructTree(pre,preStart+num+1,preEnd,in,inRootPos+1,inEnd,hm);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return constructTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,hm);
    }
}
