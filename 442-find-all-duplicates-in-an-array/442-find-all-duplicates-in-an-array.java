class Solution 
{
    public List<Integer> findDuplicates(int[] nums) 
    {
        List<Integer> res = new ArrayList<Integer> ();
        int n = nums.length;
        int arr[] = new int[n+1];
        
        for(int i = 0; i<n; i++)
        {
            arr[nums[i]]++;
            if(arr[nums[i]] == 2)
                res.add(nums[i]);
        }
        
        return res;
        
    }
}