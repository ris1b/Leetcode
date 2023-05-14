class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for(int i=0; i<arr1.length; i++){
            if(check(arr2, arr1[i], d)){
                count++;
            }
        }
        return count;
    }
    public boolean check(int [] a, int target, int d){
        int lo = 0, hi = a.length-1;
        
        while(lo <= hi){ 
            int mid = (lo+hi)/2;
            int val = Math.abs(a[mid]-target);
            
            if(val <= d) return false;
            else if(a[mid] < target){
                lo = mid+1;
            } else{
                hi = mid-1;
            }
        }
        
        return true;
    }
}