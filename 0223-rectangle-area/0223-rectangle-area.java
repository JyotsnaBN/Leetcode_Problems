class Solution 
{
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) 
    {
        int r1 = (ax2-ax1)*(ay2-ay1);
        int r2 = (bx2-bx1)*(by2-by1);
        int r = 0;
        int x1, x2, y1, y2;
        
        x1 = Math.max(ax1, bx1);
        x2 = Math.min(ax2, bx2);
        
        y1 = Math.max(ay1, by1);
        y2 = Math.min(ay2, by2);
        
        if(x1<x2 && y1<y2)
            r = (x2-x1)*(y2-y1);
        
        return r1 - r + r2;
    }
}