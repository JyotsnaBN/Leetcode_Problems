class Solution 
{
    public int uniquePathsWithObstacles(int[][] arr) 
    {
        int m = arr.length;
        int n = arr[0].length;
        int dp[][] = new int[m+1][n+1];
        
        if(arr[0][0] == 1 || arr[m-1][n-1] == 1)
            return 0;
        
        for(int i = 0; i<m; i++)
            dp[i][n] = 0;
        for(int i = 0; i<n; i++)
            dp[m][i] = 0;
        
        for(int i = m-1; i>=0; i--)
        {
            for(int j = n-1; j>=0; j--)
            {
                if(arr[i][j]==1)
                    continue;
                
                
                if(i==m-1 && j == n-1)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }
        
        return dp[0][0];
    }
}