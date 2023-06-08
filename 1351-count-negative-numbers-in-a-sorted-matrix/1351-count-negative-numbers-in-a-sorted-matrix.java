class Solution {
    public int countNegatives(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        int count = 0;

        for (int i = 0; i < row; i++) {
            count += (col - bs(grid[i]));
        }

        return count;
    }
    
    int bs(int arr[]) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] < 0)  hi = mid - 1;

            else lo = mid + 1;
        }

        return lo;
    }
}

/** 
[
    [ 4, 3, 2,-1],
    [ 3, 2, 1,-1],
    [ 1, 1,-1,-2],
    [-1,-1,-2,-3]
]
*/