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
    int res;
    public int goodNodes(TreeNode root) 
    {
        res = 0;
        int max = root.val;
        
        func(root, max);
        
        return res;
    }
    
    public void func(TreeNode root, int max)
    {
        if(root == null)
            return;
        if(root.val>=max)
        {
            res++;
            max = Math.max(root.val, max);
        }
        func(root.left, max);
        func(root.right, max);
    }
}