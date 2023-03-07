class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int lo = 0; int hi = n-1;

        while(lo <= hi){
            int mid = (hi+lo)/2;
            int x = arr[mid];
            if(x - mid - 1 < k) lo = mid+1;
                else hi = mid-1;
        }

        return lo+k;
    }
}