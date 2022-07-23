class Solution 
{
    int n;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) 
    {
        n = rooms.size();
        int v[] = new int[n];
        
        dfs(rooms, v, 0);
        
        for(int i = 0; i<n; i++)
            if(v[i]!=1)
                return false;
        
        return true;
    }
    public void dfs(List<List<Integer>> arr, int v[], int i)
    {
        v[i] = 1;
        
        for(int j = 0; j<arr.get(i).size(); j++)
        {
            int curr = arr.get(i).get(j);
            if(v[curr] == 0)
                dfs(arr, v, curr);
        }
    }
}