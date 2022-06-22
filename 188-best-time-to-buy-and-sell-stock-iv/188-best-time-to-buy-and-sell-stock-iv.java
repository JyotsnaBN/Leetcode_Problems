class Solution 
{
    public int maxProfit(int k, int[] arr) 
    {
        int n = arr.length;
        if(n == 0 || k == 0)
            return 0;
        
        int dp[][] = new int[k+1][n];
        
        /*
        arr - 1 2 4 2 5 7 2 4 9 0
        k = 2
        
            0  1  2  3  4  5  6  7  8  9
            
            1  2  4  2  5  7  2  4  9  0
        0   0  0  0  0  0  0  0  0  0  0
        1   0  1  3  3  4  6  6  6  8  8
        2   0  1  3  3  6  8  8  8  13 13
        
        The max profit could be - by not selling stock on day j ie dp[i][j-1]
                                - by purchasing the stock on day x and selling it on day j
                                If you buy a stock on day x and sell on day j, then profit 
                                = ( a[j] - a[x] ) + max profit by having i-1 transactions till day x
        Example : For [2][4]
        Either don't make a trasaction - [2][3] = 3
        Or buy on day 3 and sell on day 4 = 5-2 + ( buy on day 0 and sell on day 2) = 3 + 3 = 6
        */
        
        for(int i = 1; i<=k; i++)
        {
            for(int j = 1; j<n; j++)
            {
                dp[i][j] = dp[i][j-1];
                for(int x = 0; x<j; x++)
                {
                    int temp = arr[j] - arr[x] + dp[i-1][x];
                    dp[i][j] = dp[i][j]<temp? temp : dp[i][j];
                }
                //System.out.print(dp[i][j] + " ");
            }
            //System.out.println();
        }
        
        
        return dp[k][n-1];
    }
}