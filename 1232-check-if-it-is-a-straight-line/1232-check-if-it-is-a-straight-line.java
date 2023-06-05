class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        boolean straight = true;

        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        
        for(int i=2; i<coordinates.length; i++){
            int xcurr = coordinates[i][0];
            int ycurr = coordinates[i][1];

            if((y2-y1)*(xcurr-x2) == (ycurr-y2)*(x2-x1))
            continue;
            else straight = false;
        }

        return straight;
    }
}