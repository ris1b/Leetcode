class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i : salary){
            min = Math.min(i,min);
            max = Math.max(i,max);
            sum += i;
        }
        
        double avg = 1.0 * (sum - max-min);
        avg = avg/(salary.length - 2);

        return avg;
    }
}