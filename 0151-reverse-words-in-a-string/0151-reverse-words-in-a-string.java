class Solution 
{
    public String reverseWords(String str) 
    {
        /*Scanner sc = new Scanner(str);
        String res = "";
        while(sc.hasNext())
            res = sc.next() + " " +res;
        return res.substring(0, res.length()-1);*/
        
        String res = "", s = "";
        str = str + " ";
        for(int i = 0; i<str.length(); i++)
        {
            if(str.charAt(i) == ' ' && s.length()>0)
            {
                res = s + " " + res;
                s = "";
            }
            else if(str.charAt(i) == ' ')
                continue;
            else
                s+=str.charAt(i);        
        }
        return res.substring(0, res.length()-1);
        
    }
}