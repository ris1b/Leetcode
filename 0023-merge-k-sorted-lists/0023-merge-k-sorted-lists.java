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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        
        return mergeSort(lists, 0 , lists.length-1);
    }
    
    public ListNode mergeSort(ListNode[]lists  , int i , int n){
        if(i > n) return null;
        if(i == n) return lists[i];
        
        int mid = (i + n)/2;
        
        ListNode a = mergeSort(lists , i , mid);
        ListNode b = mergeSort(lists , mid+1,  n);
        
        return merge(a,b);
    }
    
    public ListNode merge(ListNode a, ListNode b){
        ListNode p1 = a;
        ListNode p2 = b;
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        
        while(p1!=null && p2!=null){
            if(p1.val<p2.val){
                prev.next = p1;
                p1 = p1.next;
            } else{
                prev.next = p2;
                p2=p2.next;
            }
            prev = prev.next;
        }
        
        if(p1 == null){
            prev.next = p2;
        } else{
            prev.next = p1;
        }
        
        return dummy.next;
    }
}





