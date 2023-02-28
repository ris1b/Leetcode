class Pair{
    int i; int j;
    int dist;
    Pair(int i, int j,int d){
        this.i = i;
        this.j = j;
        this.dist = d;
    }
}
class Solution {
    private static final int [] X = {-1 ,0, 1, 0};
    private static final int [] Y = { 0 ,1, 0, -1}; 
    public int maxDistance(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 1){
                    q.add(new Pair(i,j, 1));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            Pair p = q.remove();

            int dist = p.dist;
            max = Math.max(max, dist);
            for(int k = 0; k<4; k++){
                int r = p.i + X[k];
                int c = p.j + Y[k];

                if(check(r,c, grid.length, grid[0].length, grid)){
                    grid[r][c] = 1 + grid[p.i][p.j];
                    max = Math.max(max, grid[r][c]);
                    q.add(new Pair(r, c, dist+1));
                }
            }
        }
        return max == Integer.MIN_VALUE || max == 1 ? -1 : max-1;
    }
    public boolean check(int x, int y, int n, int m, int grid[][]){
        if((x < 0 || y < 0 || x >= n || y >= n || grid[x][y] != 0)) return false;

        return true;
    }
}

/**
find a water cell such that its distance to the nearest land cell is maximized,
and return the distance.
If no land or water exists in the grid, return -1.
 */

 // distance to the nearest land cell is maximized
//  dist (x0, y0) & (x1, y1) = |x0 - x1| + |y0 - y1|
