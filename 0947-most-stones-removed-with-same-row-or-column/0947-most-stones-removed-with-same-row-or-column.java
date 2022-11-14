class Solution 
{
    public int removeStones(int[][] stones) 
    {
        HashMap<Integer, List<Integer>> row = new HashMap<>();
        HashMap<Integer, List<Integer>> col = new HashMap<>();
        
        int n = 0;
        
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
        
        HashSet<Integer> rvis = new HashSet<>();
        HashSet<Integer> cvis = new HashSet<>();
        
        HashSet<Integer> rs = new HashSet<>();
        HashSet<Integer> cs = new HashSet<>();
        
        int no = 0;
        
        for(int i : row.keySet())
        {
            if(rvis.contains(i))
                continue;
  
            for(int j : row.get(i))
            {
                if(cvis.contains(j))
                    continue;
                
                no++;
                
                rs = new HashSet<>();
                cs = new HashSet<>();
                
                
                rs.add(i);
                cs.add(j);
                
                func(row, col, rvis, cvis, rs, cs);
                
            }
        }
        
        return stones.length - no;
        
        
    }
    
    
    
    public void func(HashMap<Integer, List<Integer>> row, HashMap<Integer, List<Integer>> col, HashSet<Integer> rvis, HashSet<Integer> cvis, HashSet<Integer> rs, HashSet<Integer> cs)
    {
        //System.out.println("Func - ");
        while(rs.size()!=0 || cs.size()!=0)
        {   
            while(rs.size()!=0)
            {
                int x = rs.iterator().next();
                //System.out.println("x = " + x);

                for(int y : row.get(x))
                {
                    if(!cvis.contains(y))
                    {    
                        cs.add(y);
                        //System.out.println("Add y = " + y);
                    }
                }

                rvis.add(x);
                rs.remove(x);
                //System.out.println("Rem x = " + x);
            }
            while(cs.size()!=0)
            {
                int y = cs.iterator().next();
                //System.out.println("y = " + y);
                
                for(int x : col.get(y))
                {
                    if(!rvis.contains(x))
                    {    
                        rs.add(x);
                        //System.out.println("Add x = " + x);
                    }
                }

                cvis.add(y);
                cs.remove(y);
                //System.out.println("Rem y = " + y);
            }
        }
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}