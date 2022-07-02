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
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) 
    {
        func(root, false);
        return res;
    }
    public void func(TreeNode root, boolean flag)
    {
        if(root == null)
            return;
        if(root.left == null && root.right == null && flag)
        {
            res += root.val;
        }
        func(root.left, true);
        func(root.right, false);
    }
}