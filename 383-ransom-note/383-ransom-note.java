class Solution 
{
    public boolean canConstruct(String tar, String mag) 
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<mag.length(); i++)
        {
            char c = mag.charAt(i);
            if(map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        
        for(int i = 0; i<tar.length(); i++)
        {
            char c = tar.charAt(i);
            if(map.containsKey(c) && map.get(c)>0)
            {
                map.put(c, map.get(c) - 1);
            }
            else
                return false;
        }
        return true;
    }
}