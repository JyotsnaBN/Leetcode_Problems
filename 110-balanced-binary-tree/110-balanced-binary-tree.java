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
    boolean res = true;
    public boolean isBalanced(TreeNode root) 
    {
        func(root);
        return res;
        
        
    }
    public int func(TreeNode root)
    {
        int res1 = 0, res2 = 0;
        
        if(root==null)
            return 0;
        if(root.left!=null)
            res1 = func(root.left) + 1;
        if(root.right!=null)
            res2 = func(root.right) + 1;
        
        int diff = Math.abs(res1-res2);
        if(diff>=2)
            res = false;
        return Math.max(res1, res2);
        
    }
}