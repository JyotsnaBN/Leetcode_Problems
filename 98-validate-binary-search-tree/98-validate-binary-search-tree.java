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
    public boolean isValidBST(TreeNode root) 
    {
        List<Integer> res = new ArrayList<Integer> ();
        
        func(root, res);
        
        for(int i = 1; i<res.size(); i++)
        {
            if(res.get(i)<=res.get(i-1))
                return false;
        }
        return true;
        
    }
    private void func(TreeNode root, List<Integer> res)
    {
        if(root == null)
            return;
        func(root.left, res);
        res.add(root.val);
        func(root.right, res);

    }
}