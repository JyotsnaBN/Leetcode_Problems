class Solution 
{
    public int maximum69Number (int num) 
    {
        String s = Integer.toString(num);
        for(int i = 0; i<s.length(); i++)
        {
            if(s.charAt(i) == '6')
            {
                s = s.substring(0, i) + "9" + s.substring(i+1);
                break;
            }
        }
        
        return Integer.valueOf(s);
    }
}