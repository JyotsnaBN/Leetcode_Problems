class Solution 
{
    public List<List<Integer>> combinationSum2(int[] arr, int target) 
    {
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        
        func(n, arr, 0, 0, target, res, new ArrayList<>());
        
        return res;
        
    }
    
    public void func(int n, int arr[], int j, int curr, int k, List<List<Integer>> res, List<Integer> temp)
    {
        if(curr==k)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        int t = 0;
        for(int i = j; i<n; i++)
        {
            if(i>j && arr[i] == arr[i-1])
                continue;
            t = curr + arr[i];
            if(t>k)
                break;
            temp.add(arr[i]);
            func(n, arr, i+1, t, k, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}