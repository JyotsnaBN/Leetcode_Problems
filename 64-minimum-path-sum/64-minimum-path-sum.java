class Solution 
{
    public int minPathSum(int[][] arr) 
    {
        int m = arr.length, n = arr[0].length;
        if(m==1 && n==1)
            return arr[0][0];
        
        int dp[][] = new int[m+1][n+1];
        
        for(int i = 0; i<=m; i++)
            dp[i][n] = Integer.MAX_VALUE;
        for(int i = 0; i<=n; i++)
            dp[m][i] = Integer.MAX_VALUE;
        
        dp[m-1][n-1] = arr[m-1][n-1];
        for(int i = m-1; i>=0; i--)
        {
            for(int j = n-1; j>=0; j--)
            {
                if(i == m-1 && j == n-1)
                    continue;
                dp[i][j] = arr[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
                
            }
            
        }
        
        
        /*for(int i = 0; i<=m; i++)
        {
            for(int j = 0; j<=n; j++)
            {
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }*/
        return dp[0][0];
        
    }
}