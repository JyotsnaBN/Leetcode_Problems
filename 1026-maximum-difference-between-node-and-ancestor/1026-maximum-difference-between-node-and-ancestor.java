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
    public int maxAncestorDiff(TreeNode root) 
    {
        func(root.left, root.val, root.val);
        func(root.right, root.val, root.val);
        
        return res;
    }
    
    
    public void func(TreeNode root, int min, int max)
    {
        if(root == null)
            return;
        if(root.val>max)
            max = root.val;
        if(root.val<min)
            min = root.val;
        
        res = Math.max(res, max-min);
        
        func(root.left, min, max);
        func(root.right, min, max);
        
    }
}