class Solution 
{    
    public int minFallingPathSum(int[][] arr) 
    {
        int n = arr.length;
        if(n==1)
            return arr[0][0];
        
        for(int i = 1; i<n; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(j == 0)
                    arr[i][j] += Math.min(arr[i-1][j], arr[i-1][j+1]);
                else if(j == n-1)
                    arr[i][j] += Math.min(arr[i-1][j-1], arr[i-1][j]);
                else
                    arr[i][j] += Math.min(Math.min(arr[i-1][j-1], arr[i-1][j]), arr[i-1][j+1]);
            }
        }
        int res = Integer.MAX_VALUE;
        
        for(int i = 0; i<n; i++)
        {
            res = Math.min(res, arr[n-1][i]);
        }
        
        return res;
    }
}