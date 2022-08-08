class Solution 
{
    public int lengthOfLIS(int[] nums) 
    {
        int n = nums.length;
        int dp[] = new int[n];
        int res = 1;
        for(int i = n-1; i>=0; i--)
        {
            int max = 0;
            for(int j = i; j<n; j++)
            {
                if(nums[j]>nums[i] && dp[j]>max)
                    max = dp[j];
                    
            } 
            dp[i] = 1 + max;
            if(dp[i]>res)
                res = dp[i];
        }
        return res;
    }
}