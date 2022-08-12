class Solution 
{
    public List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        func(nums, res, n, 0, new ArrayList<Integer>());
        
        return res;
    }
    
    public void func(int nums[], List<List<Integer>> res, int n, int j, List<Integer> temp)
    {
        res.add(new ArrayList<Integer> (temp));
        if(temp.size() == n)
            return;
        
        for(int i = j; i<n; i++)
        {
            temp.add(nums[i]);
            func(nums, res, n, i+1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}