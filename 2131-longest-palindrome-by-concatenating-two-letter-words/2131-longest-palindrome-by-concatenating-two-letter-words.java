class Solution 
{
    public int longestPalindrome(String[] words) 
    {
        int res = 0, a = 0, b = 0;
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(String i : words)
        {
            map.put(i, (map.getOrDefault(i, 0) + 1 ) );
        }
        
        for(String i : map.keySet())
        {
            String s = "" + i.charAt(1) + i.charAt(0);
            int x = map.get(i);
            if(i.equals(s))
            { 
                a += (x/2)*2;
                b += x%2;
            }
            else if(map.containsKey(s))
            {
                a += Math.min(x, map.get(s));
            }
            
            //System.out.println(i + " " + s + " " + a + " " + b);
        }
        
        res = a*2;
        if(b>0)
        {
            res+=2;
        }
        
        return res;
        
    }
}