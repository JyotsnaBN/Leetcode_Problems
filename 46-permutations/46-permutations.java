class Solution 
{
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) 
    {
        int n = nums.length;
        boolean vis[] = new boolean[n];
        func(n, nums, vis, new ArrayList<Integer> ());
        return res;
    }
    public void func(int n, int arr[], boolean vis[], List<Integer> temp)
    {
        if(temp.size() == n) 
        {    
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i<n; i++)
        {
            if(vis[i])
                continue;
            temp.add(arr[i]);
            vis[i] = true;
            func(n, arr, vis, temp);
            vis[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}