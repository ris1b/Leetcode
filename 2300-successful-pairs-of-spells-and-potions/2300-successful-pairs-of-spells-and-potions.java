class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        
        int m = potions.length;
        int[] ans = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int c = 0;
            int id = bs(spells[i], potions, success);
            
            if (id == -1)  continue;
            
            else c += (m - id);
            
            ans[i] = c;
        }
        return ans;
    }


    public int bs(int spell, int[] potions, long success) {
        int lo = 0; 
        int hi = potions.length - 1;
        int id = -1;
        while(lo <= hi){
            int mid = (lo + (hi - lo) / 2);
            if ((long) spell * potions[mid] >= success){
                id = mid;
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return id;   
    }
}