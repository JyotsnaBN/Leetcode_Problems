class Solution 
{
    public String intToRoman(int num) 
    {
        int a = 0, b = 0, c = 0, d = 0;
        
        String res = "";
        
        d = num%10;
        num/=10;
        
        if(num>0)
        {
            c = num%10;
            num/=10;
        }
        if(num>0)
        {
            b = num%10;
            num/=10;
        }
        if(num>0)
        {
            a = num%10;
        }
        //System.out.println(a + " " + b + " " + c +  " " + d);
        
        
        res = func(d, "I", "V", "X");
        res = func(c, "X", "L", "C") + res;
        res = func(b, "C", "D", "M") + res;
        res = func(a, "M", "", "") + res;
        
        
        return res;
    }
    
    
    public static String func(int a, String s1, String s2, String s3)
    {
        //System.out.println(a +" "+ s1 +" "+ s2 +" "+ s3);
        String res = "";
        if(a == 0)
            res = "";
        else if(a == 1)
            res = s1;
        else if(a == 5)
            res = s2;
        else if(a == 4)
            res = s1 + s2;
        else if(a == 9)
            res = s1 + s3;
        else if(a<5)
            res = s1 + func(a - 1, s1, s2, s3);
        else if(a<9)
            res = s2 + func(a - 5, s1, s2, s3);
        
        return res;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}