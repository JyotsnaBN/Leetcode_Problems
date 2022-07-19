class Solution 
{
    int clr, og, n, m;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) 
    {
        n = image.length;
        m = image[0].length;
        clr = color;
        og = image[sr][sc];
        
        if(clr==og)
            return image;
        
        func(image, sr, sc);
        
        return image;
        
    }
    public void func(int arr[][], int i, int j)
    {
        if(i<0 || j<0 || i>=n || j>=m || arr[i][j]!=og)
            return;
        arr[i][j] = clr;
        func(arr, i+1, j);
        func(arr, i-1, j);
        func(arr, i, j+1);
        func(arr, i, j-1);
    }
}