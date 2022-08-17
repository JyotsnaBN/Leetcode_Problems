class Solution 
{
    public int uniqueMorseRepresentations(String[] words) 
    {
        String arr[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        HashSet<String> res = new HashSet<>();
        
        for(int i = 0; i<words.length; i++)
        {
            String temp = "";
            String s = words[i];
            for(int j = 0; j<s.length(); j++)
            {
                temp += arr[(int)s.charAt(j)-'a'];
            }
            res.add(temp);
        }
        return res.size();
        
    }
}