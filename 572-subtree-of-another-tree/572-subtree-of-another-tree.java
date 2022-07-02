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
    public boolean isSubtree(TreeNode root, TreeNode sub) 
    {
        if(root==null || sub==null)
            return false;
        if(isSame(root, sub))
            return true;
        return isSubtree(root.left, sub) || isSubtree(root.right, sub);       
    }
    public boolean isSame(TreeNode root, TreeNode sub)
    {
        if(root==null && sub==null)
            return true;
        if(root==null || sub==null)
            return false;
        if(root.val == sub.val)
            return isSame(root.left, sub.left) && isSame(root.right, sub.right);
        return false;
    }
}