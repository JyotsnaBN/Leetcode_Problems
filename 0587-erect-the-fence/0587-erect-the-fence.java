public class Solution 
{    
    public int[][] outerTrees(int[][] points) 
    {
        int n = points.length;
        if (n <= 3)
            return points;
        
        int[] bmm = points[0];
        for (int[] p: points)
            if (p[1] < bmm[1])
                bmm = p;
        int bm[] = bmm;
        Arrays.sort(points, new Comparator<int[]> () 
        {
            public int compare(int[] p, int[] q) 
            {
                double diff = orientation(bm, p, q) - orientation(bm, q, p);
                if (diff == 0)
                    return distance(bm, p) - distance(bm, q);
                else
                    return diff > 0 ? 1 : -1;
            }
        });
        
        
        int i = n - 1;
        
        
        while (i >= 0 && orientation(bm, points[n - 1], points[i]) == 0)
            i--;
        
        for (int l = i + 1, h = n - 1; l < h; ) 
        {
            int[] temp = points[l];
            points[l++] = points[h];
            points[h--] = temp;
        }
        
        
        Stack<int[]> stack = new Stack< > ();
        stack.push(points[0]);
        stack.push(points[1]);
        
        
        for (int j = 2; j < n; j++) 
        {
            int[] top = stack.pop();
            while (orientation(stack.peek(), top, points[j]) > 0)
                top = stack.pop();
            stack.push(top);
            stack.push(points[j]);
        }
        return stack.toArray(new int[stack.size()][]);
        
        
    }
    
    
    public int orientation(int[] p, int[] q, int[] r) 
    {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
    }
    
    public int distance(int[] p, int[] q) 
    {
        return (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
    }

}