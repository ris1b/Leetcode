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
    public ListNode swapPairs(ListNode head) {
        // let there are just two nodes
        if(head == null || head.next == null) return head;

        ListNode temp = head;
        ListNode temp2 = head.next;

        temp.next = temp2.next;
        temp2.next = temp;

        temp.next = swapPairs(temp.next);

        return temp2;

    }
}