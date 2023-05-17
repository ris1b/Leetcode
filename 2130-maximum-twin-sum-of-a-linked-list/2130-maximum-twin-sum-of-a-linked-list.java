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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode revHead = rev(slow);
        slow = head;

        int max = Integer.MIN_VALUE;
        while(revHead != null){
            max = Math.max(max, slow.val + revHead.val);
            revHead = revHead.next;
            slow = slow.next;
        }

        return max;

    }

    public ListNode rev(ListNode head){
        ListNode prev = null;
        ListNode nx = head;

        while(nx != null){
            nx = nx.next;
            head.next = prev;
            prev = head;
            head = nx;
        }

        return prev;
    }

}