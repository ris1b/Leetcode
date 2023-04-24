class Solution {
    public int lastStoneWeight(int[] stones) {
        // using comparator
        // Queue<Integer> max = new PriorityQueue<>((a,b) -> b-a);
        
        Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones)
            max.offer(i);

        while(max.size() > 1){
            int x = max.poll();
            int y = max.poll();

            if(x != y)
                max.offer(x-y);
        }
        
        return max.size() == 0 ? 0 : max.poll();
    }
}