class Solution 
{
    public boolean validPalindrome(String s) 
    {
        int n = s.length(), i = 0, j = n-1;
        
        while(i<=j)
        {
            if(s.charAt(i) == s.charAt(j))
            {
                i++;
                j--;
            }
            else
            {
                String s1 = s.substring(0, i) + s.substring(i+1);
                String s2 = s.substring(0, j) + s.substring(j+1);
                return isPal(s1) || isPal(s2);
            }
        }
        return true;
    }
    public boolean isPal(String s)
    {
        int n = s.length();
        for(int i = 0; i<=n/2; i++)
        {
            if(s.charAt(i) != s.charAt(n-i-1))
                return false;
        }
        return true;
    }
}