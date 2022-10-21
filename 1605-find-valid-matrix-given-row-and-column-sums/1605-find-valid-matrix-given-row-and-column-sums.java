class Solution 
{
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) 
    {
        int r = rowSum.length, c = colSum.length;
        
        int res[][] = new int[r][c];
        int ind = 0, min = 0;
        for(int i = 0; i<r; i++)
        {
            for(int j = 0; j<c; j++)
            {
                res[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= res[i][j];
                colSum[j] -= res[i][j];
            } 
        }
        return res;
        
        
    }
}