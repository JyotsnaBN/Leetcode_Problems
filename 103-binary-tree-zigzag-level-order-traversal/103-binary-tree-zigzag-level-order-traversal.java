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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        List<TreeNode> list = new ArrayList<TreeNode> ();
        int i = 1;
        boolean flag = true;
        
        if(root==null)
            return res;
        
        res.add(new ArrayList<Integer> ());
        res.get(0).add(root.val);
        list.add(root);
        
        List<TreeNode> temp = new ArrayList<TreeNode> ();
        
        while(!list.isEmpty())
        {
            //System.out.println(i);
            TreeNode curr = list.get(0);
            list.remove(0);
            
            if(curr.left!=null)
            {
                temp.add(curr.left);  
            }
            if(curr.right!=null)
            {
                temp.add(curr.right);
            }
            
            
            if(list.isEmpty())
            {
                if(temp.isEmpty())
                break;
                
                res.add(new ArrayList<Integer> ());
                for(TreeNode n : temp)
                        res.get(i).add(n.val);
                if(i%2!=0)
                {  
                    Collections.reverse(res.get(i));
                }

                i++;
                flag = true;
                //System.out.println(temp);
                list = new ArrayList<>(temp);
                temp.clear();
                
            }
            
        }
        
        return res;
        
    }
}