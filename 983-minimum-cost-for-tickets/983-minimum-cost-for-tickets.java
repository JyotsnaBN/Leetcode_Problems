class Solution 
{
    public int mincostTickets(int[] days, int[] costs) 
    {
        int n = days.length;
        int c1 = costs[0], c2 = costs[1], c3 = costs[2];
        
        int dp[] = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 0; i<n; i++)
        {
            int day = days[i];
            int cost = dp[i];
            //System.out.print(day +"   " + cost + "  " );
            
            int index = bSearch(days, day+1);
            dp[index] = Math.min(dp[index], cost + c1 );
            //System.out.print(index + "  ");
                
            index = bSearch(days, day+7);
            dp[index] = Math.min(dp[index], cost + c2 );
            //System.out.print(index + "  ");
            
            index = bSearch(days, day+30);
            dp[index] = Math.min(dp[index], cost + c3 );    
            //System.out.println(index + "  ");
        }
        return dp[n];
        
    }
    public int bSearch(int arr[], int k)
    {
        int n = arr.length;
        //System.out.println(k);
        if(k>arr[n-1])
            return n;
        int l = 0, r = n, mid = 0;
        while(l<r)
        {
            mid = (l+r)/2;
            if(k>arr[mid])
                l = mid + 1;
            else
                r = mid;
        }
        //System.out.println("\n"+k + "  " + r) ;
        return r;
    }
    
}










