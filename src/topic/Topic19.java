package topic;

/**
 * @author: ywx
 * @description 删除链表的倒数第 N 个结点
 * @Date: 2022/07/21
 */

public class Topic19 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    // 找倒数第 k 个节点
    private ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;

        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        ListNode newHead = new ListNode(1);
        ListNode newHead1 = new ListNode(2);
        newHead.next = newHead1;
        ListNode newHead2 = new ListNode(3);
        newHead1.next = newHead2;
        ListNode newHead3 = new ListNode(4);
        newHead2.next = newHead3;
        newHead3.next = new ListNode(5);

        new Topic19().removeNthFromEnd(newHead, 2);

    }
}
