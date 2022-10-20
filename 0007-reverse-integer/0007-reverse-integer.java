class Solution 
{
    public int reverse(int x) 
    {
        int res = 0;
        int max = Integer.MAX_VALUE/10, min = Integer.MIN_VALUE/10;
        boolean sign = false;
        if(x<0)
        {    
            sign = true;
            x *= -1;
        }
        while(x>0)
        {
            if(res>max || res<min)
                return 0;
            res*=10;
            res += x%10;
            x/=10;            
        }
        if(sign)
            res *= -1;
        return res;
    }
}