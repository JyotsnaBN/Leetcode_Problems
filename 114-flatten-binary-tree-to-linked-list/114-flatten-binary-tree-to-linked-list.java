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
        if(root==null)
            return;
        TreeNode curr = root;
        if(curr.left==null && curr.right == null)
            return;
        while(curr!=null)
        {
            if(curr.left==null)
                curr = curr.right;
            else
            {
                //Find the right most child of the left subtree and link it to the right child of the current node
                //Rearrange the pointers accordingly
                //Move to the right of the current node
                TreeNode res = func(curr.left);
                res.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
                curr = curr.right;
            }
        }
  
    }
    public TreeNode func(TreeNode curr)
    {
        while(curr.right!=null)
        {
            curr=curr.right;
        }
        return curr;
    }
}




/*
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
*/