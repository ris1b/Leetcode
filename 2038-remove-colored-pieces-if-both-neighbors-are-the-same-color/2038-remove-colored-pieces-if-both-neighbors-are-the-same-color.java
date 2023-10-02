class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();

        int conutA = 0;
        int conutB = 0;

        for(int k=1; k<n-1; k++){
            char c = colors.charAt(k);
            if(c == colors.charAt(k-1) && c == colors.charAt(k+1)) {
                if(c == 'A') conutA++;
                else conutB++;
            }
        }
        // System.out.println(conutA + " " + conutB);
        return conutA - conutB > 0;
    }
}