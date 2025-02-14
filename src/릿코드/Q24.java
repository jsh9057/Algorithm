package 릿코드;

public class Q24 {
    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(0,head);
            ListNode prev = dummy;
            ListNode now = head;

            while(now!=null && now.next!=null){
                ListNode tmp = now.next.next;
                ListNode tmp2 = now.next;

                prev.next = tmp2;
                prev.next.next = now;
                now.next = tmp;

                prev = now;
                now = tmp;
            }
            return dummy.next;
        }
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
