class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();
        int n = board.length;
        int m = board[0].length;
        
        
        // rows
        for(int i=0;i<n; i++){
            set.clear();
            for(int j=0;j<m; j++){
                char c = board[i][j];
                
                if(c == '.') continue;
                
                if(set.contains(c)){
                    return false;
                } else{
                    set.add(c);
                }
            }
        }
        
        // col
        for(int i=0;i<n; i++){
            set.clear();
            for(int j=0;j<m; j++){
                char c = board[j][i];
                
                if(c == '.') continue;
                
                if(set.contains(c)){
                    return false;
                } else{
                    set.add(c);
                }
            }
        }
        
        // box
        for(int i=0;i<n; i++){
            set.clear();
            // i = 0, 
            // i= i /3; -> 0
            // i = i %3; -> 0
            int x = i / 3;
            int y = i % 3;
            for(int j = 3*x; j<3*x + 3; j++){
                for(int k =y*3; k < y*3 + 3; k++){
                    char c = board[k][j];
                    
                    if(c == '.') continue;
                    
                    if(set.contains(c)){
                        return false;
                    } else{
                        set.add(c);
                    }
                }
            }
        }
        return true;
    }
}













