class Solution 
{
    int res = Integer.MAX_VALUE;
    int n, m;
    int dp[][][];
    public int shortestPath(int[][] grid, int k) 
    {
        m = grid.length;
        n = grid[0].length;
        
        boolean arr[][] = new boolean[m][n];
        
        dp = new int[m][n][k+1];
        
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
                Arrays.fill(dp[i][j], -1);
        }
        
        Arrays.fill(dp[0][0], 0);
        
        res = func(grid, m-1, n-1, k, arr);

        
        if(res == Integer.MAX_VALUE)
            return -1;
        return res;        
    }
    
    public int func(int[][] grid, int i, int j, int k, boolean arr[][])
    {

        if(i<0 || j<0 || i>=m || j>=n || arr[i][j] || k<0)
            return Integer.MAX_VALUE;
        
        if(dp[i][j][k] != -1)
            return dp[i][j][k];
        
        if(grid[i][j] == 1 && k>0)
            k--;
        
        else if(grid[i][j] == 1)
        {    
            dp[i][j][k] = Integer.MAX_VALUE;
            return dp[i][j][k];
        }
        
        arr[i][j] = true;
        int d = func(grid, i, j-1, k, arr);
        int c = func(grid, i, j+1, k, arr);
        int a = func(grid, i-1, j, k, arr);
        int b = func(grid, i+1, j, k, arr);
        

        arr[i][j] = false;
        
        
        int r = Math.min(a, Math.min(b, Math.min(c, d)));
        if(r==Integer.MAX_VALUE)
        {    
            dp[i][j][k] = Integer.MAX_VALUE;
            return Integer.MAX_VALUE;
        }
        
        dp[i][j][k] = r+1;
        
        return dp[i][j][k];
    }
}