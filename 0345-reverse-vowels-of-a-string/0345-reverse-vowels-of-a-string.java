class Solution 
{
    public String reverseVowels(String s) 
    {
        List<Character> list = new ArrayList<Character>();
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        for(int i = 0; i<s.length(); i++)
        {
            if(set.contains(s.charAt(i)))
                list.add(s.charAt(i));
        }
        
        String res = "";
        int j = 0;
        for(int i = s.length() - 1; i>=0; i--)
        {
            if(set.contains(s.charAt(i)))
                res = "" + list.get(j++) + res;
            else
                res = s.charAt(i) + res;
        }
        
        return res;
    }
}