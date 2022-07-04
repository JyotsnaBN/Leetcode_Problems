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
    /*List<Integer> list = new ArrayList<Integer> ();
    public int kthSmallest(TreeNode root, int k) 
    {
        func(root);
        return list.get(k-1);
        
    }
    public void func(TreeNode root)
    {
        if(root==null)
            return;
        func(root.left);
        list.add(root.val);
        func(root.right);
    }*/
    
    int count = 0, res;
    public int kthSmallest(TreeNode root, int k) 
    {
        func(root, k);
        return res;
    }
    public void func(TreeNode root, int k)
    {
        if(root==null)
            return;
        
        func(root.left, k);
        
        count++;
        if(count==k)
            res = root.val;
        
        func(root.right, k);  
    }
    
}