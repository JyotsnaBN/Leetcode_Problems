class Solution 
{
    char ch[] = {'A', 'C', 'G', 'T'};
    boolean result = false;
    public int minMutation(String start, String end, String[] bank) 
    {
        HashSet<String> set = new HashSet<String> ();
        for(int i = 0; i<bank.length; i++)
            set.add(bank[i]);
        if(!set.contains(end))
            return -1;
        
        Set<String> visitedA = new HashSet<>();
        Set<String> visitedB = new HashSet<>();
        visitedA.add(start);
        visitedB.add(end);
        
        Set<String> visited = new HashSet<>();
        
        boolean flag = true;
        int len = 0;

        while(visitedA.size()!=0 && visitedB.size()!=0)
        {
            if(flag)
            {
                visitedA = new HashSet<> (func(visitedA, visitedB, visited, set));

                if(result)
                    return len+1;
            }
            else
            {
                visitedB = new HashSet<> (func(visitedB, visitedA, visited, set));

                if(result)
                    return len+1;
            }
            
            flag = !flag;
            len++;   
        }
        
        if(!result)
            return -1;
        return len;
        
    }
    
    public Set<String> func(Set<String> visA, Set<String> visB, Set<String> vis, Set<String> set)
    {
        Set<String> res = new HashSet<>();
        for(String w : visA)
        {
            char arr[] = w.toCharArray();
            for(int i = 0; i<arr.length; i++)
            {
                char og = arr[i];
                for(char c : ch)
                {
                    arr[i] = c;
                    String t = String.valueOf(arr);
                    if(visB.contains(t))
                    {    
                        result = true;
                        return new HashSet<String> ();
                    }
                    else if(!vis.contains(t) && set.contains(t))
                    {
                        res.add(t);
                    }
                }
                arr[i] = og;
            }
            vis.add(w);
        }
        
        return res;
    }
    
    
}