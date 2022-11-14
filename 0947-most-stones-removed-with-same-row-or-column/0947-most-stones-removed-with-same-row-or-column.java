class Solution 
{
    public int removeStones(int[][] stones) 
    {
        HashMap<Integer, List<Integer>> row = new HashMap<>();//Map with row and all cols connected to it
        HashMap<Integer, List<Integer>> col = new HashMap<>();//Map with col and all rows connected to it
                
        for(int i = 0; i<stones.length; i++)
        {
            int x = stones[i][0], y = stones[i][1];
            
            if(!row.containsKey(x))
                row.put(x, new ArrayList<Integer>());
            row.get(x).add(y);
            
            if(!col.containsKey(y))
                col.put(y, new ArrayList<Integer>());
            col.get(y).add(x);
        }
        
        HashSet<Integer> rvis = new HashSet<>();//Rows visited
        HashSet<Integer> cvis = new HashSet<>();//Cols visited
        
        
        Stack<Integer> rs = new Stack<Integer>();//Current rows to be visited
        Stack<Integer> cs = new Stack<Integer>();//Current cols to be visited
        
        int no = 0;
        
        for(int i : row.keySet())
        {
            if(rvis.contains(i))
                continue;
  
            for(int j : row.get(i))
            {
                if(cvis.contains(j))
                    continue;
                
                no++;//Count number of islands
                               
                rs.push(i);
                cs.push(j);
                
                func(row, col, rvis, cvis, rs, cs);   //Call the function for one stone in each island       
            }
        }
        
        return stones.length - no;    
    }
    
    
    
    public void func(HashMap<Integer, List<Integer>> row, HashMap<Integer, List<Integer>> col, HashSet<Integer> rvis, HashSet<Integer> cvis, Stack<Integer> rs, Stack<Integer> cs)
    {
        while(!rs.isEmpty() || !cs.isEmpty())
        {   
            while(!rs.isEmpty())
            {
                int x = rs.pop();
                for(int y : row.get(x))//For a particular row, add all the cols it is connected to
                {
                    if(!cvis.contains(y))  
                        cs.push(y);
                }
                rvis.add(x);
            }
            while(!cs.isEmpty())
            {
                int y = cs.pop();
                for(int x : col.get(y))
                {
                    if(!rvis.contains(x)) 
                        rs.push(x);
                }
                cvis.add(y);
            }
        }   
    }
   
}