class Solution 
{
    public boolean containsNearbyDuplicate(int[] nums, int k) 
    {
        int x = 0, y = k, n = nums.length;
        if(k>=n)
            k = n-1;
        if(n==1)
            return false;
        y = k;
        
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i = x; i<=y; i++)
        {
            set.add(nums[i]);
        }
        if(set.size()<=k)
            return true;
        //System.out.println(set);
        for(int i = 1; i+k<n; i++)
        {
            //System.out.println(set);
            set.remove(nums[i-1]);
            set.add(nums[i+k]);
            
            if(set.size()<=k)
                return true;
        }
        return false;
        
    }
}