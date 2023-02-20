class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if(index < 0){
            index = Math.abs(index) - 1;
        }
        return index;
    }
}