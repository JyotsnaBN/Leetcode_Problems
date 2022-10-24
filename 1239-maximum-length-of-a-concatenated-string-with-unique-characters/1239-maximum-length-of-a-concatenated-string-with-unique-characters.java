class Solution 
{
    int res = 0;
    public int maxLength(List<String> arr) 
    {
        Collections.sort(arr, Collections.reverseOrder());
        if(arr.get(0).length() == 26)
            return 26;
        
        int n = arr.size();
        
        func(arr, n, 0, "");
        
        return res;
        
    }
    
    public void func(List<String> arr, int n, int i, String s)
    {
        //System.out.println(i + "  " + s);
        
        HashSet<Character> set = new HashSet<Character>();
        
        for(int j = 0; j<s.length(); j++)
        {
            set.add(s.charAt(j));
        }
        if(s.length()==set.size() && res<s.length())
            res = s.length();
        else if(s.length()!=set.size())
            return;
        
        if(i>=n)
            return;
        
        String temp = s;
        for(int j = i; j<n; j++)
        {
            temp = s;
            s += arr.get(j);
            func(arr, n, j+1, s);
            s = temp;
        }
    }
}