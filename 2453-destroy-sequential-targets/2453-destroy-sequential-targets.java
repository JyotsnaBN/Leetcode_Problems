class Solution 
{
    public int destroyTargets(int[] nums, int k) 
    {
        int n = nums.length;
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int max = 0;
        
        for(int i = 0; i<n; i++)
        {
            int rem = (int)(nums[i] % k);
            if(map.containsKey(rem))
                map.put(rem, map.get(rem)+1);
            else
                map.put(rem, 1);
            
            //System.out.println(nums[i] + " " + rem + " " + map.get(rem));
            
            if(map.get(rem)>max)
            {
                max = map.get(rem);
            }
        }

        
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i<n; i++)
        {
            if(map.get((int)(nums[i]%k)) == max)
                return nums[i];
        }
        
        return nums[0];
    }
}
