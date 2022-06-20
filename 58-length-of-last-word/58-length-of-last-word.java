class Solution 
{
    public int lengthOfLastWord(String s) 
    {
        Scanner sc = new Scanner(s);
        int res = 0;
        while(sc.hasNext())
            res = sc.next().length();
        return res;
    }
}