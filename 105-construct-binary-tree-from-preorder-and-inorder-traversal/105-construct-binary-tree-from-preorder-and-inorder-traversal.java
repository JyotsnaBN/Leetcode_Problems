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
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        int n = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        int index = lSearch(inorder, root.val, 0, n-1);
        
        TreeNode left = func(preorder, 1, n-1, inorder, 0, index - 1);
        
        TreeNode right = func(preorder, index + 1, n-1, inorder, index + 1, n-1);
        
        root.left = left;
        root.right = right;
        
        return root;     
    }
    
    public TreeNode func(int po[], int ps, int pe, int io[], int is, int ie)
    {
        int n = po.length;
        if(ps>=n || is>=n || is>ie || ps>pe)
            return null;
        TreeNode curr = new TreeNode(po[ps]);
        if(pe-ps == 0 || ie-is == 0)
            return curr;
        int index = lSearch(io, po[ps], is, ie);
        TreeNode left = func(po,     ps + 1,           pe, io, is,        index - 1);
        TreeNode right = func(po, ps + index - is + 1, pe, io, index + 1, ie);
        
        curr.left = left;
        curr.right = right;
        
        return curr;
    }
    
    public int lSearch(int arr[], int x, int s, int e)
    {
               
        for(int i = s; i<=e; i++)
        {
            if(arr[i] == x)
                return i;
        }
        return 0;
    }
}