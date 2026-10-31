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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 =reverse(l1);
        l2 =reverse(l2);

        ListNode newHead = new ListNode(-1,null);
        ListNode dummy = newHead;
        int sum=0;
        int carry=0;
        while(l1!=null || l2!=null || carry!=0){
            sum =carry;
            if(l1!=null){
                sum += l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum +=l2.val;
                l2=l2.next;
            }
            dummy.next = new ListNode(sum%10);
            carry = sum/10;
            dummy =dummy.next;
        }
        return reverse(newHead.next);

    }
    public ListNode reverse(ListNode head){
        ListNode prev =null;
        ListNode curr =head;
        while(curr!=null){
            ListNode temp =curr.next;
            curr.next=prev;
            prev =curr;
            curr = temp;
        }
        return prev;
    }
}