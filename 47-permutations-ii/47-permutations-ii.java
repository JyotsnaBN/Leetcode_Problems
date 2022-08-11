class Solution 
{
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) 
    {
        int n = nums.length;
        Arrays.sort(nums);
        boolean vis[] = new boolean[n];
        func(n, 0, nums, vis, new ArrayList<Integer> ());
        return res;
    }
    public void func(int n, int j, int arr[], boolean vis[], List<Integer> temp)
    {
        if(temp.size() == n) 
        {    
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i<n; i++)
        {
            if(vis[i] || i>0 && arr[i] == arr[i-1] && vis[i-1])
                continue;
            temp.add(arr[i]);
            vis[i] = true;
            func(n, i, arr, vis, temp);
            vis[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}