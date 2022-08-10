class Solution 
{
    public List<List<Integer>> combinationSum(int[] arr, int target) 
    {
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        
        func(n, arr, 0, target, res, new ArrayList<>());
        
        return res;
        
    }
    
    public void func(int n, int arr[], int curr, int k, List<List<Integer>> res, List<Integer> temp)
    {
        if(curr==k)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        int t = 0;
        for(int i = 0; i<n; i++)
        {
            if(temp.size()>0 && arr[i]>temp.get(temp.size() - 1))
                break;
            t = curr + arr[i];
            if(t>k)
                break;
            temp.add(arr[i]);
            func(n, arr, t, k, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}