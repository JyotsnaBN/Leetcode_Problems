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
    public void flatten(TreeNode root) 
    {
        List<TreeNode> list = new ArrayList<TreeNode> ();
        if(root==null)
            return;
        func(root, list);
        TreeNode curr = root;
        for(int i = 1; i<list.size(); i++)
        {
            curr.right = list.get(i);
            curr.left = null;
            curr = curr.right;
        }
        curr.right = null;
        curr.left = null;
        
        
        
    }
    public void func(TreeNode root, List<TreeNode> list)
    {
        if(root==null)
            return;
        list.add(root);
        func(root.left, list);
        func(root.right, list);
    }
}