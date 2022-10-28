class Solution 
{
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String i : strs)
        {
            char temp[] = i.toCharArray();
            Arrays.sort(temp);
            String s = new String(temp);
            
            if(map.containsKey(s))
            {
                map.get(s).add(i);
            }
            else
            {
                map.put(s, new ArrayList<String>());
                map.get(s).add(i);
            }
        }
        
        List<List<String>> res = new ArrayList<List<String>>();
        
        for(String i : map.keySet())
        {
            res.add(map.get(i));
        }
        
        return res;
        
    }
}