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
        
        int total = (int)Math.pow(2, height(root)+1) - 1;//Find the maximum number of nodes the tree can have
        int rem = 0, lh = 0, rh = 0;//Find the number of nodes not present
        
        while(root!=null)
        {
            lh = height(root.left);//Find the height of left subtree
            rh = height(root.right);//Find the height of right subtree
            
            if(lh>rh)//Right subtree does not have any node in its last level
            {
                rem += Math.pow(2, lh);//Count the nodes not present
                root = root.left;//Move to left subtree
            }
            else//Left subtree is full, so move to right subtree
                root = root.right;
        }
        
        return total - rem;
    }
    
    
    public int height(TreeNode root)//leaf nodes are considered to be at height 0
    {
        if(root == null)
            return -1;
        if(root.left == null)
            return 0;
        return height(root.left) + 1;
    }
}