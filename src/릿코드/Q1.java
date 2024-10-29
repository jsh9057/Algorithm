package 릿코드;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Q1 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode a = l1.next;
        ListNode b = l2.next;

        ListNode now = head;
        while (a!=null || b!=null) {

            int num1;
            if(a==null){ num1=0; }
            else{ num1= a.val; }

            int num2;
            if(b==null){ num2=0; }
            else{ num2=b.val; }

            int up = (num1 + num2)/10;
            int r = num1 + num2 - up*10;

            now.next = new ListNode(r);
            now = now.next;
        }

        return head.next;
    }

}
