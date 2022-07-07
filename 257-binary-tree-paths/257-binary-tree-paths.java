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
    public List<String> binaryTreePaths(TreeNode root) 
    {
        ArrayList<String> res = new ArrayList<String>();        
        func(root, "", res);
        return res;        
    }
	
    public void func(TreeNode root, String s, ArrayList<String> res) 
    {
        if (root == null) 
            return;    	
        if (root.left==null && root.right==null) 
            res.add(s + root.val);
       
        func(root.left, s + root.val + "->", res);    	
        func(root.right, s + root.val + "->", res);    	    	
    }
    
}