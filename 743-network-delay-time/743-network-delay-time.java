class Solution 
{
    public int networkDelayTime(int[][] times, int n, int k) 
    {
        //Create a graph where u -> (all nodes connected to it, weight)
        Map<Integer, ArrayList<Pair<Integer, Integer>>> graph = new HashMap<Integer, ArrayList<Pair<Integer, Integer>>>();
        for(int i = 1; i<=n; i++)
        {
            graph.put(i, new ArrayList<Pair<Integer, Integer>> ());
        }
        for(int i = 0; i<times.length; i++)
        {
            graph.get(times[i][0]).add(new Pair<Integer, Integer> (   times[i][1], times[i][2]    ) );
        }
        
        int dist[] = new int[n+1];//Create a distance array to store the minimun distance between source and ith node
        boolean vis[] = new boolean[n+1];//Have we already visited this node
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        
        for(int i = 0; i<n; i++)
        {
            int u = getIndex(dist, vis);//Find the index of the node with minimum distance which has not been visited yet
            if(u == -1)
                break;
            vis[u] =  true;//Mark the node as visited
            for(int j = 0; j<graph.get(u).size(); j++)//Go to every node we can reach from the current node and calculate the new distance to that node as = weight to reach that node from prev node + min dist to prev node from source
            {
                int v = graph.get(u).get(j).getKey();
                int w = graph.get(u).get(j).getValue();
                dist[v] = Math.min(dist[v], dist[u] + w);
            }
        }
        
        int res = 0;
        
        for(int i = 1; i<=n; i++)
        {
            if(dist[i] == Integer.MAX_VALUE)
                return -1;
            res = Math.max(res, dist[i]);
        }
        return res;
        
    }
    public int getIndex(int dist[], boolean vis[])
    {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0; i<dist.length; i++)//Find the node which hasn't been visited yet with minimum distance
        {
            if(!vis[i] && dist[i]<min)
            {
                min = dist[i];
                index = i;
            }
        }
        
        return index;
    }
}