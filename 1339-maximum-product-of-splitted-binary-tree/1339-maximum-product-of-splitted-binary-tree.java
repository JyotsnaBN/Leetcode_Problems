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
    long total;
    double max;
    public int maxProduct(TreeNode root) 
    {
        total = totalSum(root);
        max = 0;        
        func(root);
        return (int)(max % 1000000007);
    }
    
    public int totalSum(TreeNode root)
    {
        if(root == null)
            return 0;
        
        return root.val + totalSum(root.left) + totalSum(root.right);
    }
    
    
    public int func(TreeNode root)
    {
        if(root == null)
            return 0;
        
        int sum = root.val + func(root.left) + func(root.right);
        double prod = (double) (sum *  (total - sum));
        max = Math.max(max, prod);
        
        return sum;
    }
}