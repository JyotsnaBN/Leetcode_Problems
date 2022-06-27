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
class Solution 
{
    public int maxDepth(TreeNode root) 
    {
        if(root==null)
            return 0;
        return func(root);
        
        
    }
    public int func(TreeNode root)
    {
        int res = 0;
        if(root.left!=null)
            res = func(root.left);
        if(root.right!=null)
            res = Math.max(res, func(root.right));
        return res + 1;
    }
}