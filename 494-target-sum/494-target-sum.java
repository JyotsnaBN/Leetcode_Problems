class Solution 
{
    public int findTargetSumWays(int[] nums, int k) 
    {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i<n; i++)
            sum+=nums[i];
        
        if(n==1 && (k==sum || k==(-1*sum)))
            return 1;
        else if(n==1 && !(k==sum || k==(-1*sum)))
            return 0;
        
        
        int dp[][] = new int[n+1][sum*2 + 1];
        
        if((sum<k && k>0)||(sum<(-1*k) && k<0))
            return 0;
       
        
        dp[0][sum] = 1;
        HashSet<Integer> set = new HashSet<Integer> ();
        set.add(sum);
        for(int i = 0; i<n; i++)
        {
            HashSet<Integer> set1 = new HashSet<Integer> ();
            //System.out.println("--");
            for(int j : set)
            {
                dp[i+1][j-nums[i]] += dp[i][j];
                dp[i+1][j+nums[i]] += dp[i][j];
                set1.add(j-nums[i]);
                set1.add(j+nums[i]);
                //System.out.println((j-nums[i]) + "  " +( j+nums[i]));
            }
            
            set.clear();
            set.addAll(set1);
            set1.clear();
        }
        return dp[n][sum+k];
    }
}