class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    public int climbStairs(int n) 
    {
        if(n==0)
            memo.put(0,0);
        else if(n==1)
            memo.put(1,1);
        else if(n==2)
            memo.put(2,2);
        else {}
        int res;
        if(memo.containsKey(n))
            return memo.get(n);
        else
        {
            res = climbStairs(n-2) + climbStairs(n-1);
            memo.put(n, res);
        }
            
        return res;
        
    }
}