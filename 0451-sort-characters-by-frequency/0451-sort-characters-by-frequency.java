class Solution 
{
    public String frequencySort(String s) 
    {
        int n = s.length();
        
        TreeMap<Character, Integer> map = new TreeMap<>();
        
        for(int i = 0; i<n; i++)
        {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }        
        Map sortedMap = valueSort(map);
        
        Iterator i = sortedMap.entrySet().iterator();
  
        char c;
        int k;
        String res = "";
        while (i.hasNext()) 
        {
            Map.Entry mp = (Map.Entry)i.next();
            c = (char)mp.getKey();
            k = (int)mp.getValue();
            
            while(k>0)
            {
                res+=c;
                k--;
            }
        }
        
        return res;
        
    }
        
    public static <K, V extends Comparable<V> > Map<K, V> 
        valueSort(final Map<K, V> map)
    {
        Comparator<K> valueComparator = new Comparator<K>() 
        {
            public int compare(K k1, K k2)
            {
                int comp = map.get(k2).compareTo(map.get(k1));
                if (comp == 0)
                    return 1;
                else
                    return comp;
            }
            
        };
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);        
        sorted.putAll(map);  
        return sorted;
    }
}