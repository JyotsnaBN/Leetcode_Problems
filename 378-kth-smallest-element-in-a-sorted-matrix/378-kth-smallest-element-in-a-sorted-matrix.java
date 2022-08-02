class Solution 
{
    public int kthSmallest(int[][] mat, int k) 
    {
        int n = mat.length;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(q.size()<k)
                    q.add(mat[i][j]);
                else
                {
                    if(mat[i][j]<q.peek())
                    {
                        q.poll();
                        q.add(mat[i][j]);
                    }
                }
            }
        }
        
        return q.peek();
        
    }
}





/*

class Solution 
{
    public int kthSmallest(int[][] mat, int k) 
    {
        PriorityQueue<Element> q = new PriorityQueue<Element>(new ElementComparator());
        Set<String> vis = new HashSet<String> ();
        int n = mat.length;
        
        vis.add("" + 0 + "," + 0);
        q.add(new Element(0, 0, mat[0][0]));
        
        
        int c = 0;
        
        while(!q.isEmpty())
        {
            int i = q.peek().i;
            int j = q.peek().j;
            int val = q.poll().val;
            c++;
            if(c==k)
                return val;
            
            
            if(i+1<n)
            {
                String t = "" + (i + 1) + "," + j;
                if(!vis.contains(t))
                {
                    vis.add(t);
                    q.add(new Element(i+1, j, mat[i+1][j]));
                }
            }
            if(j+1<n)
            {
                String t = "" + i + "," + (j + 1);
                if(!vis.contains(t))
                {
                    vis.add(t);
                    q.add(new Element(i, j + 1, mat[i][j + 1]));
                }
            }
            
        }
        
        
        return 0;
    }
}


class Element
{
    int i, j, val;
    Element(int i, int j, int val)
    {
        this.i = i;
        this.j = j;
        this.val = val;
    }
}
class ElementComparator implements Comparator<Element>
{
    public int compare(Element e1, Element e2)
    {
        if(e1.val<e2.val)
            return -1;
        else if(e1.val>e2.val)
            return 1;
        return 0;
    }
}

*/