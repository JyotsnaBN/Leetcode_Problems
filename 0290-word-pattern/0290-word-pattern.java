class Solution 
{
    public boolean wordPattern(String p, String s) 
    {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        
        Scanner sc = new Scanner(s);
        
        char c;
        String str;
        
        for(int i = 0; i<p.length(); i++)
        {
            c = p.charAt(i);
            if(!sc.hasNext())
                return false;
            str = sc.next();
            if(map.containsKey(c) && !map.get(c).equals(str))
            {
                return false;
            }
            else if(!map.containsKey(c) && set.contains(str))
            {
                return false;
            }
            else if(!map.containsKey(c))
            {
                map.put(c, str);
                set.add(str);
            }
        }
        if(sc.hasNext())
                return false;
        return true;
    }
}