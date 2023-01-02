class Solution 
{
    public boolean detectCapitalUse(String word) 
    {
        int c = 0;
        int n = word.length();
        
        if(n==1)
            return true;
        
        for(int i = 0; i<n; i++)
        {
            if(Character.isUpperCase(word.charAt(i)))
                c++;
        }
        
        if(c == n || c == 0)
            return true;
        
        if(c == 1 && Character.isUpperCase(word.charAt(0)))
            return true;
        
        return false;
    }
}