class Solution {
    public int minFallingPathSum(int[][] arr) 
    {
        int n = arr.length;
        
        int dp[][] = new int[n][n+2];
        
        for(int i = 0; i<n; i++)
        {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][n+1] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i<n; i++)
            dp[n-1][i+1] = arr[n-1][i];
        
        for(int i = n-2; i>=0; i--)
        {
            for(int j = 1; j<n+1; j++)
            {
                dp[i][j] = Math.min(  Math.min(  dp[i+1][j-1], dp[i+1][j]  ) , dp[i+1][j+1] );
                dp[i][j] += arr[i][j-1];
            }
        }
        int min  = dp[0][1];
        for(int i = 1; i<=n; i++)
            if(dp[0][i] < min)
                min = dp[0][i];
        
        /*for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<n+2; j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }*/
        
        return min;
    }
}