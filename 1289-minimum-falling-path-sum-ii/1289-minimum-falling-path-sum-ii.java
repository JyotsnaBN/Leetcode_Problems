class Solution 
{
    public int minFallingPathSum(int[][] arr) 
    {
        int n = arr.length;
        if(n==1)
            return arr[0][0];
        if(n==2)
        {
            int i1 = arr[0][0] + arr[1][1];
            int i2 = arr[1][0] + arr[0][1];
            return i1<i2?i1: i2;
        }
        
        int minsum1 = arr[n-1][0], minsum2 = Integer.MAX_VALUE, mini1 = 0, mini2 = 0;
        
        for(int i = 0; i<n; i++)
        {
            if(minsum1>arr[n-1][i])
            {
                minsum2 = minsum1;
                minsum1 = arr[n-1][i];
                mini2 = mini1;
                mini1 = i;
            }
            else if(minsum2>arr[n-1][i])
            {
                minsum2 = arr[n-1][i];
                mini2 = i;
            }
        }
        
        
        for(int i = n-2; i>=0; i--)
        {
            int currmin1 = Integer.MAX_VALUE, currmin2 = Integer.MAX_VALUE, i1 = 0, i2 = 0;
            //System.out.println("\n i = " + i);
            for(int j = 0; j<n; j++)
            {
                int temp;
                if(j==mini1)
                    temp = arr[i][j] + minsum2;
                else
                    temp = arr[i][j] + minsum1;
                if(temp<currmin1)
                {
                    currmin2 = currmin1;
                    currmin1 = temp;
                    i2 = i1;
                    i1 = j;
                }
                else if(temp<currmin2)
                {
                    currmin2 = temp;
                    i2 = j;
                }
                //System.out.println(currmin1 + " " + currmin2 + "  ");
            }
            minsum1 = currmin1;
            minsum2 = currmin2;
            mini1 = i1;
            mini2 = i2;
        }
        
        return minsum1;
    }
}