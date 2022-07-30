package topic;

/**
 * @author: ywx
 * @description 相交链表
 * @Date: 2022/07/30
 */

public class Topic160 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        int l1 = 0, l2 = 0;
        while (p1 != null) {
            l1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            l2++;
            p2 = p2.next;
        }
        p1 = headA;
        p2 = headB;
        if (l1 <= l2) {
            for (int i = 0; i< l2-l1;i++) {
                p2 = p2.next;
            }
        }else {
            for (int i = 0; i< l1 - l2 ; i++) {
                p1 = p1.next;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
