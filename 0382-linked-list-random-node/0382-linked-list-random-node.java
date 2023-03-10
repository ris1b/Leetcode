/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    HashMap<Integer, Integer> map;
    ListNode head;
    int n;
    public Solution(ListNode head) {
        this.head = head;
        map = new HashMap<>();
        ListNode temp = head;
        
        while(temp != null){
            map.put(n, temp.val);
            temp = temp.next;
            n++;
        }
    }
    
    public int getRandom() {
        double rand =  107 * Math.random();
        int idx = (int)(rand % n + n) % n;
        
        return map.get(idx);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */