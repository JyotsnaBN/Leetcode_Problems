class Solution 
{
    int res = Integer.MAX_VALUE;
    public int numSquares(int k) 
    {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i<=Math.sqrt(k); i++)
        {
            list.add(i*i);
        }
        Collections.sort(list);
        
        int dp[] = new int[k+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        int n = list.size();
        for(int i = 1; i<=k; i++)
        {
            if(list.contains(i))
            {    
                dp[i] = 1;
                continue;
            }
            int sum = 0;
            for(int j = 0; j<n; j++)
            {
                sum = i - list.get(j);
            
                if(sum<0)
                    continue;
 
                if(dp[i] == Integer.MAX_VALUE && dp[sum] == Integer.MAX_VALUE)
                    continue;
                if(dp[sum] != Integer.MAX_VALUE)
                    dp[i] = (int)Math.min(dp[i], dp[sum] + 1);
            }
        }
        if(dp[k]==Integer.MAX_VALUE || dp[k] < 0)
            return -1;
        return dp[k];
        
    }
        
}