class Solution 
{
    public List<String> wordSubsets(String[] words1, String[] words2) 
    {
        HashMap<Character, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<String>();
        for(String w : words2)
        {
            HashMap<Character, Integer> temp = new HashMap<>();
            for(int i = 0; i<w.length(); i++)
            {
                char c = w.charAt(i);
                if(temp.containsKey(c))
                    temp.put(c, temp.get(c) + 1);
                else
                    temp.put(c, 1);
            }
            for (Map.Entry<Character, Integer> entry : temp.entrySet()) 
            {
                char key = entry.getKey();
                int val = entry.getValue();
                if(map.containsKey(key))
                {
                    int max = Math.max( map.get(key), temp.get(key));
                    map.put(key, max);
                }
                else
                {
                    map.put(key, val);
                }
            } 
        }
        
        for(String w : words1)
        {
            boolean flag = true;
            HashMap<Character, Integer> temp = new HashMap<>();
            for(int i = 0; i<w.length(); i++)
            {
                char c = w.charAt(i);
                if(temp.containsKey(c))
                    temp.put(c, temp.get(c) + 1);
                else
                    temp.put(c, 1);
            }
            
            for (Map.Entry<Character, Integer> entry : map.entrySet()) 
            {
                char key = entry.getKey();
                int val = entry.getValue();
                if(!(temp.containsKey(key) && temp.get(key)>=val))
                {
                    flag = false;
                    break;
                }
                    
            } 
            if(flag)
                res.add(w);
            
            
        }
        
        return res;
        
        
    }
}