class Solution 
{
    public boolean closeStrings(String s1, String s2) 
    {
        int n1 = s1.length(), n2 = s2.length();
        
        if(n1!=n2)
            return false;
        
        char arr[] = s1.toCharArray();        
        Arrays.sort(arr);        
        s1 = new String(arr);
        
        arr = s2.toCharArray();
        Arrays.sort(arr);        
        s2 = new String(arr);
        
        if(s1.equals(s2))
            return true;
        
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        for(int i = 0; i<n1; i++)
        {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }
        
        for(int i = 0; i<n1; i++)
        {
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }
        
        
        if(!map1.keySet().equals(map2.keySet()))
            return false;
        
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        
        for(char c : map1.keySet())
        {
            if(map1.get(c)!=map2.get(c))
            {
                l1.add(map1.get(c));
                l2.add(map2.get(c));
            }
        }
        
        Collections.sort(l1);
        Collections.sort(l2);
        
        if(!l1.equals(l2))
            return false;
        return true;
        
    }
}