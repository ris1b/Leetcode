class Solution {
    public int addDigits(int num) {
        return add(num);
    }

    int add(int n){
        if(n < 10) return n;

        int x = 0;
        while(n > 0){
            x += n % 10;
            n /= 10;
        }
        return add(x);
    }
}