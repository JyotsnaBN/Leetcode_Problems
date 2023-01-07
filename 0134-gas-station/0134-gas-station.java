class Solution 
{
    public int canCompleteCircuit(int[] g, int[] c) 
    {
        int n = g.length;
        int sum = 0;
        int curr = 0, ind = 0;
        for(int i = 0; i<n; i++)
        {
            g[i] = g[i] - c[i];
            sum += g[i];
            curr += g[i];
            if(curr<0)
            {
                curr = 0;
                ind = i+1;
            }
            
            
        }
        if(sum<0 || curr<0)
            return -1;
        
        
        return ind;
    }
}