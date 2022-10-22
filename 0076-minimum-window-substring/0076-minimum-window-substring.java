class Solution 
{
    public String minWindow(String s, String t) 
    {
        String res = "";
        int m = s.length(), n = t.length();
        
        if(m<n)
            return res;
        
        int map1[] = new int[128];
        int map2[] = new int[128];
        
        int have = 0, need = 0;
        s += "0";
        m++;
        
        for(int i = 0; i<n; i++)//Add all characters in t to map2 with its count
        {
            map2[(int)t.charAt(i)]++;
            if(map2[(int)t.charAt(i)] == 1)//count the number of unique chars in this string
                need++;
        }
        
        int i = 0, j = 0;
        for(j = 0; j<n; j++)//Add the 1st n characters of s to map1 with its count
        {
            char c = s.charAt(j);
            
            map1[(int)c]++;
            
            
            if(map2[(int)c] == map1[(int)c] && map2[(int)c] != 0)//check how many of the unique chars from t are present in s
                have++;
        }
        
        
        if(have == need)
            return s.substring(i, j);
        
        boolean flag = true;
        
        /*
        Use a sliding window approach
        i to track the beginning of the substring and j the end
        Add chars from the right till we have all the chars from t in that substring of s                                      ---   j++
        Then remove chars from the left while having all chars from t in the substring of s                                    ---   i--
        When we reach a point where we cannot remove any more chars from the left, start adding chars from right again         ---   j++
        This switch is achieved using flag
        */
        
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