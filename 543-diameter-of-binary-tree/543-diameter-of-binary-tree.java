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
    public int diameterOfBinaryTree(TreeNode root) 
    {
        func(root);
        return res;
    }
    public int func(TreeNode root)
    {
        if(root==null)
            return 0;
        int t1 = func(root.left) , t2 = func(root.right);
        res = Math.max(res, t1 + t2 );
        return Math.max(t1 , t2 ) + 1;
    }
}