class Solution 
{
    int n, m;
    public int numIslands(char[][] grid) 
    {
        n = grid.length;
        m = grid[0].length;
        
        if(n==0 || m == 0)
            return 0;
        int res = 0;
        
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<m; j++)
            {
                if(grid[i][j] == '1')
                {
                    func(i, j, grid);
                    res++;
                }
            }
        }
        return res;
    }
    public void func(int i, int j, char grid[][])
    {
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]=='0')
            return;
        grid[i][j] = '0';
        func(i-1,j,grid);
        func(i+1,j,grid);
        func(i,j-1,grid);
        func(i,j+1,grid);
    }
}