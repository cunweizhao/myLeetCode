package com.zcw.leetcode;

/**
 * @program: my-leetcode
 * @description: 两数相加
 * @author: Zhaocunwei
 * @create: 2021-01-12 16:42
 **/

public class Test2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode newHead = new ListNode(0);
        ListNode head3 = newHead;
        // 进位标志
        boolean carry = false;
        while (head1 != null || head2 != null) {
            // 获取对应位置的值然后相加
            int x = (head1 != null) ? head1.val : 0;
            int y = (head2 != null) ? head2.val : 0;
            int sum = carry ? (x + y + 1) : (x + y);
            // 处理进位
            if (sum >= 10){
                sum -= 10;
                carry = true;
            } else {
                carry = false;
            }
            // 新增节点
            head3.next = new ListNode(sum % 10);
            head3 = head3.next;
            if (head1 != null){
                head1 = head1.next;
            }
            if (head2 != null){
                head2 = head2.next;
            }
        }
        if (carry) {
            head3.next = new ListNode(1);
        }
        return newHead.next;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
