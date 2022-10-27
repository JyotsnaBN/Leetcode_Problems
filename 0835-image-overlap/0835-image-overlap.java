class Solution 
{
    public int largestOverlap(int[][] a, int[][] b) 
    {
		int max = 0, n = a.length;;
		for (int x = 1 - n; x < n; x++) 
			for (int y = 1 - n; y < n; y++) 
				max = Math.max(max, overlapCount(a, b, x, y, n));
		return max;
	}

	public int overlapCount(int[][] a, int[][] b, int x, int y, int n) 
    {
		int count = 0;
		for (int i = 0; i < n; i++) 
        {
			for (int j = 0; j < n; j++) 
            {
				if (i - x >= 0 && j - y >= 0 && i - x < n && j - y < n) 
                {
					if (a[i][j] == b[i - x][j - y] && a[i][j] == 1) 
						count++;
				}
			}
		}
		return count;
	}
}