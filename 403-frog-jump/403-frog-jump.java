class Solution 
{
    public boolean canCross(int[] arr) 
    {
        int n = arr.length;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();

        if(arr[1]!=1)
            return false;
        
        
        for(int i = 0; i<n; i++)
        {
            map.put(arr[i], new HashSet<Integer> ());
        }
        map.get(0).add(1);
        map.get(1).add(1);
        map.get(1).add(2);
        
        for(int i = 1; i<n; i++)
        {
            //System.out.println();
            HashSet<Integer> list = new HashSet<Integer> ();
            list = map.get(arr[i]);
            
            //System.out.println(arr[i] + "  " + list);
            
            if(list.size()==0 && i==n-1)
                return false;
            else if(list.size() == 0)
                continue;
            for(int k:list)
            {
                
                /*if ((arr[i] + k - 1)!=arr[i] &&  map.containsKey(arr[i] + k - 1))
                {
                    HashSet<Integer> set1 = map.get(arr[i] + k - 1);
                    
                    System.out.println("1 - " + (arr[i] + k - 1));
                    
                    if(k-2>0)
                    {    
                        set1.add(k-2);
                        System.out.println(k-2);
                    }
                    if(k-1>0)
                    {    
                        set1.add(k-1);
                        System.out.println(k-1);
                    }
                    set1.add(k); 
                    System.out.println(k);
                }*/
                if ((arr[i] + k)!=arr[i] && map.containsKey(arr[i] + k))
                {
                    HashSet<Integer> set2 = map.get(arr[i] + k);
                    
                    //System.out.println("2 - " + (arr[i] + k));
                    
                    if(k-1>0)
                    {    
                        set2.add(k-1);
                        //System.out.println(k-1);
                    }
                    set2.add(k); 
                    //System.out.println(k);
                    set2.add(k+1);
                    //System.out.println(k+1);
                }
                /*if ((arr[i] + k + 1)!=arr[i] && map.containsKey(arr[i] + k + 1))
                {
                    HashSet<Integer> set3 = map.get(arr[i] + k + 1);
                    
                    System.out.println("3 - " + (arr[i] + k + 1));
                    
                    set3.add(k);
                    System.out.println(k);
                    set3.add(k+1);
                    System.out.println(k+1);
                    set3.add(k+2); 
                    System.out.println(k+2);
                }*/
            }
        }
        
        
        
        
        
        
        return true;
    }
}