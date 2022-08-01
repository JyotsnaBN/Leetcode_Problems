class Solution 
{
    public int longestCycle(int[] arr) 
    {
        int n = arr.length;
        boolean vis[] = new boolean[n];
        boolean dv[] = new boolean[n];
        boolean cycle[] = new boolean[n];
        
        //Run DFS for every node and if a cycle can be formed from that node, set cycle[i] to true
        for(int i = 0; i<n; i++)
        {
            if(!vis[i])
            {
                dfs(i, arr, vis, dv, cycle);
            }
        }
        int res = -1;
        
        //Traverse the cycle array, find the length of every cycle and store the max length
        for(int i = 0; i<n; i++)
        {
            int t = 0;
            if(cycle[i])
            {
                boolean v[] = new boolean[n];
                while(!v[i])
                {
                    v[i] = true;
                    i = arr[i];
                    t++;
                    
                }
                res = Math.max(res, t);
            }
            
        }
        return res;
    }
    
    public void dfs(int i, int arr[], boolean vis[], boolean dv[], boolean cycle[])
    {
        if(dv[i] == true)//If we visit a node already visited, there is a cycle at that node
        {    
            cycle[i] = true;
            return;
        }
        //Set the temporary visited array to true, traverse its adjacent nodes and set it to false at the end
        
        int t = arr[i];
        
        if(t != -1 && !vis[i])
        {    
            dv[i] = true;
            dfs(t, arr, vis, dv, cycle);
            dv[i] = false;
        }
        
        vis[i] = true;
        
    }

}