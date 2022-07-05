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
    public List<Integer> largestValues(TreeNode root) 
    {
        List<Integer> res = new ArrayList<Integer> ();
        func(root, res, 0);
        return res;    
    }
    public void func(TreeNode root, List<Integer> res, int i)
    {
        if(root==null)
            return;
        if(res.size()==i)
            res.add(Integer.MIN_VALUE);
        if(res.get(i)<root.val)
            res.set(i, root.val);
        
        func(root.left, res, i+1);
        func(root.right, res, i+1);
    }    
}