class Solution 
{
    public String minWindow(String s, String t) 
    {
        String res = "";
        int m = s.length(), n = t.length();
        if(m<n)
            return res;
        //System.out.println(m + " " + n);

        
        
        int map1[] = new int[128];
        int map2[] = new int[128];
        
        int have = 0, need = 0;
        s += "0";
        m++;
        for(int i = 0; i<n; i++)
        {
            map2[(int)t.charAt(i)]++;
            if(map2[(int)t.charAt(i)] == 1)
                need++;
        }
        
        int i = 0, j = 0;
        for(j = 0; j<n; j++)
        {
            char c = s.charAt(j);
            
            map1[(int)c]++;
            
            
            if(map2[(int)c] == map1[(int)c] && map2[(int)c] != 0)
                have++;
        }
        
        
        if(have == need)
            return s.substring(i, j);
        
        boolean flag = true;
        
        while(i<m-n && j<m)
        {
            
            if(flag)
            {
                char c = s.charAt(j);
                
                map1[(int)c]++;


                if(map2[(int)c] == map1[(int)c] && map2[(int)c] != 0)
                    have++;
                
                if(have == need)
                {
                    if(j-i+1 < res.length() || res.length() == 0)
                        res = s.substring(i, j+1);
                    flag = false;
                    
                }
                j++;
            
            }
            if(!flag)
            {
                char c = s.charAt(i);
                //map1.put(c, map1.get(c) - 1);
                map1[(int)c]--;
                
                if(map2[(int)c] <= map1[(int)c] )
                {
                    i++;
                    if(j-i < res.length() || res.length() == 0)
                        res = s.substring(i, j);
                }
                else
                {
                    map1[(int)c]++;
                    flag = true; 
                }
            }
            
            
        }
        
        return res;
        
    }
}