class Solution 
{
    public boolean checkSubarraySum(int[] nums, int k) 
    {
        int n = nums.length;
        if(n == 1)
            return false;
        if(k == 1)
            return true;
        
        nums[0] %= k;
        
        if(n>2 && nums[1] == 0 && nums[2] == 0)
            return true;
        
        nums[1] += nums[0];
        nums[1] %= k;
        
        if(nums[1] == 0)
                return true;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        map.put(nums[0], 1);
        if(nums[0]==nums[1])
            map.put(nums[1], 2);
        else
            map.put(nums[1], 1);
        
        for(int i = 2; i<n; i++)
        {
            if(i<n-1 && nums[i]==0 && nums[i+1]==0)
                return true;
            nums[i] += nums[i-1];
            nums[i] %= k;
            if(nums[i] == 0)
                return true;
            
            if(map.containsKey(nums[i])   &&  (  nums[i-1]!=nums[i]  || (map.get(nums[i]) > 1) ) )
                return true;
            
            if(map.containsKey(nums[i]))
                map.put(nums[i], 2);
            else
                map.put(nums[i], 1);
            
        }
        
        
        return false;
    }
}