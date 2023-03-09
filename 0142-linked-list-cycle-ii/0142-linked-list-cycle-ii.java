/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        if(head.next.next == null) return null;
        ListNode f = head;
        ListNode s = head;

        while(f.next != null && f.next.next != null){
            f =  f.next.next;
            s = s.next;
            if(f == s){ //cycle present
                break;
            }
        }
        
        if(f == s){     // --> cycle present
            ListNode p1 = head;
            while(p1 != s){
                p1 = p1.next;
                s = s.next;
            }
            return s;
        }
        return null;
        
    }
}