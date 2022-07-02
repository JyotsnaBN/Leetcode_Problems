/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution 
{
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        func(root, p, q);
        return res;
    }
    public boolean func(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root==null)
            return false;
        
        
        
        boolean b1 = func(root.left, p, q), b2 = func(root.right, p, q);
        
        //System.out.println(root.val + "  " + b1 + "  " + b2);
        if(root.val==p.val || root.val==q.val)
        {
            if((b1||b2)&&(res==null))
            {
                res = root;
            }
            return true; 
        }
        if(b1&&b2&&res==null)
        {
            res = root;
            return true;
        }
        
        return b1||b2;
        
    }
}