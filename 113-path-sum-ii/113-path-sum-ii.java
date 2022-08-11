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
    public List<List<Integer>> pathSum(TreeNode root, int k) 
    {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(root.val);
        func(root, k, res, root.val, temp);
        
        return res;
    }
    public void func(TreeNode root, int k, List<List<Integer>> res, int sum, List<Integer> temp)
    {
        if(root.left == null && root.right == null && sum==k)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        if(root.left!=null)
        {
            temp.add(root.left.val);
            sum+=root.left.val;
            func(root.left, k, res, sum, temp);
            sum-=root.left.val;
            temp.remove(temp.size()-1);
        }
        if(root.right!=null)
        {
            temp.add(root.right.val);
            sum+=root.right.val;
            func(root.right, k, res, sum, temp);
            sum-=root.right.val;
            temp.remove(temp.size()-1);
        }
        
        
        
        
    }
}