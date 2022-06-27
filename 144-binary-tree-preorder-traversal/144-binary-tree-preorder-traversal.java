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
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        List<Integer> list = new ArrayList<Integer> ();
        Stack<TreeNode> stack = new Stack<TreeNode> ();
        if(root == null)
            return list;
        stack.push(root);
        TreeNode curr = root;
        while(!stack.isEmpty())
        {
            curr = stack.pop();
            list.add(curr.val);
            if(curr.right!=null)
                stack.push(curr.right);
            if(curr.left!=null)
                stack.push(curr.left);
                
        }
        return list;
        
    }

}