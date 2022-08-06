class Solution 
{
    public List<String> letterCombinations(String s) 
    {
        String arr[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int n = s.length();
        List<String> res = new ArrayList<String> ();
        if(n==0)
            return res;
        func(s, n, arr, res, "");
        return res;
    }
    
    public void func(String s, int n, String arr[], List<String> res, String prev)
    {
        if(prev.length() == n)
        {
            res.add(prev);
            return;
        }
        String temp = s.substring(1);
        int num = Integer.valueOf(s.substring(0,1));
        
        for(int i = 0; i<arr[num].length(); i++)
        {
            prev += arr[num].charAt(i);
            func(temp, n, arr, res, prev);
            prev = prev.substring(0, prev.length() - 1);
        }
        
    }
    
}