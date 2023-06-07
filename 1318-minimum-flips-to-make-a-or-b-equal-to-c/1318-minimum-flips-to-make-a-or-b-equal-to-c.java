class Solution {
    public int minFlips(int a, int b, int c) {
        int cnt = 0;
        for(int i=0; i<32; i++){
            boolean aa = check(a, i);
            boolean bb = check(b, i);
            boolean cc = check(c, i);

            if(cc){
                if(!aa && !bb) cnt++;
            } else {
                if(aa) cnt++;
                if(bb) cnt++;
            }
        }

        return cnt;
    }

    public boolean check(int n, int i){
        return ((n & (1 << i)) != 0);
    }
}

// 2 -> 010
// 6 -> 110
// ---------
// 5 -> 101
// ---------

// 4 -> 100
// 2 -> 010

// 7 -> 111