class Solution 
{
    public List<String> letterCasePermutation(String s) 
    {
        List<String> res = new ArrayList<String>();
        
        func(s, res, 0);
        
        return res;
        
    }
    public void func(String s, List<String> res, int j)
    {
        res.add(s);
        String temp = s;
        char ch = 'a';
        for(int i = j; i<s.length(); i++)
        {
            ch = s.charAt(i);
            if(ch>='0' && ch<='9')
                continue;
            temp = s;
            if(Character.isUpperCase(ch))
                s = s.substring(0, i) + Character.toLowerCase(s.charAt(i)) + s.substring(i+1);
            else
                s = s.substring(0, i) + Character.toUpperCase(s.charAt(i)) + s.substring(i+1);
            
            func(s, res, i+1);
            
            s = temp;
        }
    }
}