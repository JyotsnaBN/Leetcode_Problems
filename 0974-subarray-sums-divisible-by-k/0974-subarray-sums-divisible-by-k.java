class Solution 
{
    public int subarraysDivByK(int[] nums, int k) 
    {        
        int n = nums.length, res = 0;
        
        nums[0] %= k;
        if(nums[0]<0)
                nums[0]+=k;
        if(nums[0] == 0)
            res++;
        
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(nums[0], 1);
        
        
        
        for(int i = 1; i<n; i++)
        {
            nums[i] += nums[i-1];
            nums[i]%=k;
            
            if(nums[i]<0)
                nums[i]+=k;
            if(nums[i] == 0)
                res++;
            
            if(map.containsKey(nums[i]))
            {
                res += map.get(nums[i]);
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else
            {
                map.put(nums[i], 1);
            }
        }
        
        return res;
    }
}