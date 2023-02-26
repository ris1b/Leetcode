class Solution {
    int x[] = {-1, 1, 0, 0};
    int y[] = {0,0,-1,1};

    public int[][] floodFill(int[][] mat, int i, int j, int color) {
        if(mat[i][j] == color) return mat;
        
        int old = mat[i][j];        // say, 1
        
        mat[i][j] = color;          // new, 2

        for(int id=0;id < x.length;id++){
            int i1 = i + x[id];
            int i2 = j + y[id];
            if(check(i1, i2, mat, old)) 
                floodFill(mat, i1, i2, color);
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