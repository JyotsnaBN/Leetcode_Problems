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
    public TreeNode sortedArrayToBST(int[] nums) 
    {
        return func(nums, 0, nums.length-1);
        
    }
    public TreeNode func(int arr[], int s, int e)
    {
        if(e-s<0)
            return null;
        TreeNode curr = null;
        if(e-s==0)
        {
            curr = new TreeNode(arr[s]);
            return curr;
        }
        int m = (s+e)/2;
        curr = new TreeNode(arr[m]);
        
        TreeNode left = func(arr, s, m-1), right = func(arr, m+1, e);
        curr.left = left;
        curr.right = right;
        return curr;
    }
}