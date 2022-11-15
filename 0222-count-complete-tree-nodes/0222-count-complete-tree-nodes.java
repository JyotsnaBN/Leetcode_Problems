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
    public int countNodes(TreeNode root) 
    {
        if(root == null)
            return 0;
        if(root.left == null)
            return 1;
        if(root.right == null)
            return 2;
        
        int total = (int)Math.pow(2, height(root)+1) - 1;
        int rem = 0, lh = 0, rh = 0;
        
        while(root!=null)
        {
            lh = height(root.left);
            rh = height(root.right);
            
            if(lh>rh)
            {
                rem += Math.pow(2, lh);
                root = root.left;
            }
            else
            {
                root = root.right;
            }
        }
        
        return total - rem;
    }
    
    
    public int height(TreeNode root)
    {
        if(root == null)
            return -1;
        if(root.left == null)
            return 0;
        return height(root.left) + 1;
    }
}