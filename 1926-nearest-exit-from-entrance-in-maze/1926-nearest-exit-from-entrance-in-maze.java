class Solution 
{
    int res = Integer.MAX_VALUE;
    int m, n;
    public int nearestExit(char[][] maze, int[] ent) 
    {
        m = maze.length;
        n = maze[0].length;
        boolean vis[][] = new boolean[m][n];
        
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(maze[i][j] == '+')
                    vis[i][j] = true;
            }
        }
        
        
        Queue<List<Integer>> queue = new LinkedList<>();
        
        List<Integer> list = new ArrayList<Integer>();
        list.add(ent[0]);
        list.add(ent[1]);
        list.add(0);
        queue.add(list);
        vis[ent[0]][ent[1]] = true;
        //System.out.println();
        
        int x = 0, y = 0, val = 0;
        while(!queue.isEmpty())
        {          
            list = queue.remove();
            
            x = list.get(0);
            y = list.get(1);
            val = list.get(2);
            if(val>res)
                continue;
            //System.out.println(list  + "     " + res + "    "  + exit(x,y));
            
            if(exit(x, y) && !(x==ent[0] && y==ent[1]))
            {
                //System.out.println("exit");
                if(res>val)
                    res = val;
            }
            
            if(check(x+1, y, vis))
            {    
                list = new ArrayList<Integer>();
                list.add(x+1);
                list.add(y);
                list.add(val+1);
                queue.add(list);
                vis[x+1][y] = true;
                //System.out.println("Add - " + list);
            }
            if(check(x-1, y, vis))
            {    
                list = new ArrayList<Integer>();
                list.add(x-1);
                list.add(y);
                list.add(val+1);
                queue.add(list);
                vis[x-1][y] = true;
                //System.out.println("Add - " + list);
            }
            if(check(x, y+1, vis))
            {    
                list = new ArrayList<Integer>();
                list.add(x);
                list.add(y+1);
                list.add(val+1);
                queue.add(list);
                vis[x][y+1] = true;
                //System.out.println("Add - " + list);
            }
            if(check(x, y-1, vis))
            {    
                list = new ArrayList<Integer>();
                list.add(x);
                list.add(y-1);
                list.add(val+1);
                queue.add(list);
                vis[x][y-1] = true;
                //System.out.println("Add - " + list);
            }
            
            
        }
        if(res == Integer.MAX_VALUE)
            return -1;
        return res;
        
    }
    
    public boolean exit(int i, int j)
    {
        if(i == 0 || i == m-1 || j == 0 || j == n-1)
            return true;
        return false;
    }
    
    public boolean check(int i, int j, boolean vis[][])
    {
        if(i<0 || i>=m || j<0 || j>=n || vis[i][j])
            return false;
        return true;
    }

}