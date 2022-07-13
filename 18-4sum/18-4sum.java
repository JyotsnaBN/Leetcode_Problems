class Solution 
{
    public List<List<Integer>> fourSum(int[] nums, int target) 
    {
        Set<List<Integer>> res = new HashSet<List<Integer>> ();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i<n; i++)
        {
            for(int j = i+1; j<n; j++)
            {
                for(int k = j+1; k<n; k++)
                {
                    for(int l = k+1; l<n; l++)
                    {
                        if((long)nums[i]+nums[j]+nums[k]+nums[l] != target)
                            continue;
                        List<Integer> list = new ArrayList<Integer> ();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        Collections.sort(list);
                        
                        res.add(list);
                        break;
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        for(List<Integer> i : res)
            result.add(i);
        
        return result;
    }
}