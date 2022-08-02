class Solution 
{
    public boolean wordBreak(String s, List<String> wordDict) 
    {
        int n = s.length();
        Set<String> set = new HashSet<String> (wordDict);
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        return func(s, set, map);        
    }
    public boolean func(String s, Set<String> set, HashMap<String, Boolean> map)
    {
        int n = s.length();
        if(n==0 || set.contains(s))
            return true;
        if(map.containsKey(s))
            return map.get(s);
        for(String w : set)
        {
            if(s.startsWith(w))
            {
                boolean res = func(s.substring(w.length()), set, map);
                if(res)
                    return true;
                map.put(s, res);
            }
        }
        return false;
    }
}