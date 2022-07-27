class Solution 
{
    int n;
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ings, String[] supp) 
    {
        List<String> res = new ArrayList<String>();
        n = recipes.length;
        Set<String> store = new HashSet<String>();//Has all the available supplies in a set
        HashMap<String, Integer> reci = new HashMap<String, Integer>();//Recipes we can prepare if we have all its ing
        for(int i = 0; i<supp.length; i++)
        {
            store.add(supp[i]);
        }
        for(int i = 0; i<n; i++)
        {
            reci.put(recipes[i], i);
        }
        
        int vis[] = new int[n];//Have we already prepared this recipe... -1 if we cannot, 0 if we haven't visited, 1 if we already have
        
        boolean arr[][] = new boolean[n][n];//Graph with all recipes
        //System.out.println(n);
        for(int i = 0; i<n; i++)
        {
            //System.out.println(recipes[i]);
            List<String> temp = ings.get(i);//All ingredients required for recipe i
            for(int j = 0; j<temp.size(); j++)
            {
                String s = temp.get(j);
                if(store.contains(s))
                {    
                    temp.remove(s);
                    j--;
                }
                else if(reci.containsKey(s))
                {
                    arr[i][reci.get(s)] = true;
                }
                else
                {
                    vis[i] = -1;
                    break;
                }
                
            }
            if(temp.size() == 0)
            {    
                vis[i] = 1;
                //res.add(recipes[i]);
            }
            
            //System.out.println(ings.get(i));
        }
        
        int dv[] = new int[n];
        for(int i = 0; i<n; i++)
        {
            if(vis[i]==0)
            {
                if(func(i, arr, vis, dv))//if there is a cycle
                {    
                    vis[i] = -1;
                }
            }
            
        }
        
        
        for(int i = 0; i<n; i++)
        {
            if(vis[i]==1)
                res.add(recipes[i]);
        }
        
        
        
        
        
        return res;
    }
    
    public boolean func(int i, boolean[][] arr, int v[], int dv[])
    {
        v[i] = 1;
        dv[i] = 1;
        for(int j = 0; j<n; j++)
        {
            if(arr[i][j] == false)
                continue;
            if(v[j] == 0)
            {
                if(func(j, arr, v, dv))
                {    
                    v[i] = -1;
                    v[j] = -1;
                    return true;
                }
            }
            else if(v[j] == -1)
            {
                v[i] = -1;
                return true;
            }
            else if(dv[j] == 1)
            {    
                v[j] = -1;
                v[i] = -1;
                return true;
            }
        }
        dv[i] = 0;
        return false;
    }
    
    
    
    
}