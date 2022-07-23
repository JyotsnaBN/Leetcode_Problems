class Solution 
{
    int n;
    public List<Integer> eventualSafeNodes(int[][] graph) 
    {
        //0 represents unvisited, 1 - safe and 2 - unsafe
        n = graph.length; // number of nodes
        List<Integer> res = new ArrayList<Integer> ();
        int vis[] = new int[n];
        for(int i = 0; i<n; i++)
        {
            if(graph[i].length == 0)
            {    
                res.add(i);
                vis[i] = 1;
            }
        }
        
        for(int i = 0; i<n; i++)
        {
            //System.out.println(" ------ " + i + " ------ ");
            
            if(vis[i] == 0)
            {    
                boolean dfssoln = dfs(graph, i, vis);
                //System.out.println("DFS - " + dfssoln);
                if(dfssoln)
                {
                    res.add(i);
                    //System.out.println("Add - " + i);
                }
            }
            if(vis[i] == 1 && !res.contains(i))
            {    
                res.add(i);
                //System.out.println("Add - " + i);
            }
            //System.out.println("\n\n");
                
        }
        Collections.sort(res);
        return res;
    }
    
    public boolean dfs(int graph[][], int i, int vis[])
    {
        vis[i] = 2;//assume it is unsafe
        //System.out.println("vis of - " + i + " is 2 ");
        for(int j = 0; j<graph[i].length; j++)
        {
            int curr = graph[i][j];
            //System.out.println("curr - " + curr);
            if(vis[curr] == 2)
                return false;
            else if(vis[curr] == 1)
                continue;
            if(!dfs(graph, curr, vis))
               return false; 
        }
        
        vis[i] = 1;
        //System.out.println("vis of - " + i + " is 1 ");
        return true;
    }
}