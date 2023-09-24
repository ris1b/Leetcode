class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();

        for(int i=left; i<= right; i++){
            if(isSelfDividing(i)){
                ans.add(i);
            }
        }

        return ans;
    }

    private boolean isSelfDividing(int n){
        int x = n;
        while(x > 0){
            int prev = x;
            x = x % 10;
            if(x == 0 || n % x != 0)
                return false;
            x = prev / 10;
        }

        return true;
    }
}