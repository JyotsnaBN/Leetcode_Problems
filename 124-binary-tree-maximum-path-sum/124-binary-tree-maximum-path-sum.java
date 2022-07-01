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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) 
    {
        func(root);
        return max;
    }
    public int func(TreeNode root)
    {
        if(root==null)
            return 0;
        int r1 = func(root.left);
        int r2 = func(root.right);
        r1 = r1>0?r1:0;
        r2 = r2>0?r2:0;
        max =Math.max(max, r1+r2+root.val);
        
        return Math.max(r1, r2) + root.val;
    }
}