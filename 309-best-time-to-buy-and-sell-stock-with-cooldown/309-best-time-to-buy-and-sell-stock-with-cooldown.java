class Solution 
{
    public int maxProfit(int[] arr) 
    {
        int n = arr.length;
        int dp[] = new int[n];
        
        if(n==1)
            return 0;
        dp[0] = 0;
        /*
        dp[i] is either dp[i-1]
        Or 
        It could be a selling day, buying day - j  is 0... i-1
        If buying day is j, dp[i] = ( arr[i]-arr[j] )  + dp[j-2]     As j is buying day and j-1 will be cooldown
        */
        for(int i = 1; i<n; i++)
        {
            dp[i] = dp[i-1];
            int temp = 0;
            for(int j = i-1; j>=0; j--)
            {
                temp = 0;
                if(arr[i]>arr[j])
                    temp = arr[i] - arr[j];
                if(j-2>=0)
                    temp += dp[j-2];
                dp[i] = dp[i]>temp?dp[i]:temp;
            }
        }
        
        return dp[n-1];
        
    }
}