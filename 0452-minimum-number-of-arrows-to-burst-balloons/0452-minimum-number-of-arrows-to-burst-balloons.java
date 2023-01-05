class Solution 
{
    public int findMinArrowShots(int[][] arr) 
    {
        int n = arr.length;
        
        Arrays.sort(arr, new Comparator<int[]>() { 
          @Override              
          public int compare(final int[] e1, final int[] e2) 
          {
            if (e1[1] > e2[1])
                return 1;
            else
                return -1;
          }
        });
        
        int e = arr[0][1], res = 0;
        
        for(int i = 1; i<n; i++)
        {
            if(arr[i][0]<=e)
                continue;
            e = arr[i][1];
            res++;
        }
        
        res++;
        return res;
        
        
        
    }
}