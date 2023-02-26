class Pair{
    int i; int j;
    Pair (int i, int j){
        this.i = i;
        this.j = j;
    }
}
class Solution {
    static final int x[] = {-1, 1, 0, 0};
    static final int y[] = {0,0,-1,1};

    public int[][] floodFill(int[][] mat, int i, int j, int color) {
        if(mat[i][j] == color) return mat;
        
        int old = mat[i][j];        // say, 1
        mat[i][j] = color;          // new, 2

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));

        while(!q.isEmpty()){
            Pair p = q.remove();
            mat[p.i][p.j] = color;

            // int old = mat[i][j];
            for(int id=0; id<4; id++){
                int r = p.i + x[id];
                int c = p.j + y[id];
                if(check(r,c,mat,old)){
                    q.add(new Pair(r,c));
                }
            }
        } 
        return mat;
    }

    public boolean check(int i , int j, int [][] mat, int old){
        if(i<0 || i>=mat.length || j>= mat[0].length || j<0 || mat[i][j] != old){
            return false;
        }
        return true;
    }
}