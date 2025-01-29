package 릿코드;


public class Q21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode now = head;
        while(list1 != null && list2 != null){
            if(list1.val>list2.val){
                now.next = list2;
                list2 = list2.next;
            }
            else{
                now.next = list1;
                list1 = list1.next;
            }
            now = now.next;
        }

        if(list1 == null){ now.next = list2; }
        else if(list2 == null){ now.next = list1; }

        return head.next;
    }
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
