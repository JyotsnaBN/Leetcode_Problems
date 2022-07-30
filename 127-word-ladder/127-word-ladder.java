class Solution 
{
    boolean result = false;
    public int ladderLength(String bw, String ew, List<String> words) 
    {
        Set<String> visitedA = new HashSet<>();
        Set<String> visitedB = new HashSet<>();
        visitedA.add(bw);
        visitedB.add(ew);
        
        if(!words.contains(ew))
            return 0;
        
        Set<String> visited = new HashSet<>();
        
        boolean flag = true;
        int len = 1;
        
        while(visitedA.size()!=0 && visitedB.size()!=0)
        {
            if(flag)
            {
                visitedA = new HashSet<> (func(visitedA, visitedB, visited, words));
                if(result)
                    return len+1;
            }
            else
            {
                visitedB = new HashSet<> (func(visitedB, visitedA, visited, words));
                if(result)
                    return len+1;
            }
            flag = !flag;
            len++;   
        }
        
        if(!result)
            return 0;
        return len;
        
    }
    
    public Set<String> func(Set<String> visA, Set<String> visB, Set<String> vis, List<String> wordss)
    {
        Set<String> res = new HashSet<>();
        Set<String> words = new HashSet<>(wordss);
        for(String w : visA)
        {
            char arr[] = w.toCharArray();
            for(int i = 0; i<arr.length; i++)
            {
                char og = arr[i];
                for(char j = 'a'; j<='z'; j++)
                {
                    arr[i] = j;
                    String t = String.valueOf(arr);
                    if(visB.contains(t))
                    {    
                        result = true;
                        return new HashSet<String> ();
                    }
                    else if(!vis.contains(t) && words.contains(t))
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