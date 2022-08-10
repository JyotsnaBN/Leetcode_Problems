class Solution 
{
    public List<List<Integer>> combinationSum3(int k, int target) 
    {
        List<List<Integer>> res = new ArrayList<>();
        
        func(0, k, target, 0, res, new ArrayList<>());
        
        return res;
        
    }
    
    public void func(int curr, int k, int target, int prev, List<List<Integer>> res, List<Integer> temp)
    {
        if(curr==target && temp.size() == k)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        int t = 0;
        for(int i = prev + 1; i<=9; i++)
        {
            t = curr + i;
            if(t>target)
                break;
            temp.add(i);
            func(t, k, target, i, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}