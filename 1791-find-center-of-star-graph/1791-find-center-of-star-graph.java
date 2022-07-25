class Solution 
{
    public int findCenter(int[][] edges) 
    {
        int a = edges[0][0], b = edges[0][1], c = edges[1][0], d = edges[1][1];
        return a==c?a : (a==d? a : (b==c? b : d));
    }
}