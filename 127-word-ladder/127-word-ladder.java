class Solution 
{
    boolean result = false;
    public int ladderLength(String bw, String ew, List<String> words) 
    {
        /*
        Bidirectional Search - 
        We start searching from both ends and increase the length in each function call and return that number
        -visitedA- will search from the -beginword- and -visitedB- from the -endword-
        -flag- is used to switch between running BFS from both ends
        
        In every function call, we update the Set to contain the next layer of nodes ie words that are different from the parent Set by one letter
        
        We traverse the parent set and for each word -w-,
        we change every letter one by one from a to z and see if that word matches a word in the set from the other side
        If it does, we change -result- to true and return that length
        If it does not, if we haven't visited this word before and this word is part of the list of words, then we add it to the set containing the next layer of words
        
        Example -
        
        vA - [hit]
        vB - [cog]
        
        vA - [hot]
        vB - [cog]
        
        vA - [hot]
        vB - [log, cog, dog]
        
        vA - [lot, dot, hot]
        vB - [log, cog, dog]
        
        vA - [lot, dot, hot]
        vB - []

        
        */
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