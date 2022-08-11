class Solution 
{
    public List<List<Integer>> combine(int k, int n) 
    {
        List<List<Integer>> res = new ArrayList<> ();
        
        func(k, n, 0, res, new ArrayList<Integer>());
        
        
        
        return res;        
    }
    
    public void func(int k, int n, int i, List<List<Integer>> res, List<Integer> temp)
    {
        if(temp.size() == n)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int j = i+1; j<=k; j++)
        {
            temp.add(j);
            func(k, n, j, res, temp);
            temp.remove(temp.size() - 1);
        }
        
    }
}