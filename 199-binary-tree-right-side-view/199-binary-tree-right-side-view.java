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
    public List<Integer> rightSideView(TreeNode root) 
    {
        List<Integer> res = new ArrayList<Integer> ();
        if(root==null)
            return res;
        res.add(root.val);
        func(root, res, 0);
        return res;
        
    }
    public void func(TreeNode root, List<Integer> res, int i)
    {
        if(root==null)
            return;
        if(res.size()==i)
            res.add(0);
        res.set(i, root.val);
        
        func(root.left, res, i+1);
        func(root.right, res, i+1);
    }
}