/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame 
{
    public int guessNumber(int n) 
    {
        int l = 1, res = l + (n - l) / 2;
        while(guess(res)!=0)
        {
            if(guess(res)==1)
                l = res + 1;
            else
                n = res - 1;
            res = l + (n - l) / 2;
        }
        
        return res;
    }
}