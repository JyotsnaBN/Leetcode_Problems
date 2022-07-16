class Solution 
{
    public String numberToWords(int num) 
    {
        if(num==0)
            return "Zero";
        String s = String.valueOf(num);
        int n = s.length();
        if(n<=3)
            return toWord(s).trim();
        else if(n<=6)
        {
            return (toWord(s.substring(0, n-3)) + " Thousand" + toWord(s.substring(n-3))).trim();
        }
        else if(n<=9)
        {
            String r1 = toWord(s.substring(n-6, n-3));
            if(r1.length()!=0)
                r1+=" Thousand"; 
            return (toWord(s.substring(0, n-6))  + " Million" +   r1 +  toWord(s.substring(n-3))).trim();
        }
        
        String r1 = toWord(s.substring(4, 7));
            if(r1.length()!=0)
                r1+=" Thousand"; 
        
        String r2 = toWord(s.substring(1, 4));
            if(r2.length()!=0)
                r2+=" Million";
        
        return (toWord(s.substring(0, 1)) + " Billion" + r2 +  r1 + toWord(s.substring(7))).trim();
    }
    
    
    
    
    public String toWord(String s)
    {
        String res = "";
        int n = s.length();
        if(n==0)
            return res;
        
        String oneDigit[] = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"};
        String twoDigits[] = {" Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
        String tens[] = {"", "", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
            
            
        if(n==1)
        {
            return oneDigit[Integer.valueOf(s)];
        }
        
        else if(n==2)
        {
            if(s.charAt(0) == '1')
            {
                return twoDigits[  Integer.valueOf(s)%10 ];
            }
            
            
            String p1 = toWord(s.substring(1));
            
            return tens[  Integer.valueOf(s)/10  ] + p1;
        }
        
        String r1 = toWord(s.substring(0,1));
        if(r1.length()!=0)
            r1 += " Hundred";
        
        return  r1 + toWord(s.substring(1));
        
        
        
    }
}