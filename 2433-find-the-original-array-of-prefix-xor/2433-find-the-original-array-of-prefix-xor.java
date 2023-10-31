class Solution {
    public int[] findArray(int[] arr) {
        int n = arr.length;
        int pf[] = new int[n];
        pf[0] = arr[0];

        for(int i=1; i<n; i++){
            pf[i] = arr[i-1] ^ arr[i];     
        }

        return pf;
    }
}