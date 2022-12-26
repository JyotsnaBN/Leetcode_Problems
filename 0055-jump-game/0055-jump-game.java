class Solution 
{
    public boolean canJump(int[] nums) 
    {
        int n = nums.length;
        boolean vis[] = new boolean[n];
        int k, val;
        boolean temp = false;
        vis[n-1] = true;
        
        for(int i = n-2; i>=0; i--)
        {
            k = nums[i];
            temp = false;
            for( ; k>=0; k--)
            {
                val = i+k;
                if(val<n && vis[val])
                {
                    temp = true;
                    break;
                }
            }
            
            vis[i] = temp;
            
        }
        
        return vis[0];
    }
}