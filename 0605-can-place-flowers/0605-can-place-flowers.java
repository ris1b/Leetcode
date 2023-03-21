class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) return true;

        for(int i=0;i<flowerbed.length; i++){
            if(n == 0) return true;
            
            if(flowerbed[i] == 0){
                int next;
                int prev;
                if(i == flowerbed.length-1) next = 0;
                    else next = flowerbed[i+1];
                    
                if(i == 0) prev = 0;
                    else prev = flowerbed[i-1];
                    
                if((next + prev) == 0){
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }

        return (n<=0);
    }
}