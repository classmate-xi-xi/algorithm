package topic;

/**
 * @author: ywx
 * @description 反转链表
 * @Date: 2022/07/27
 */

public class Topic206 {
    public class ListNode {
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

    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        ListNode node = head;
        while (node != null) {
            ListNode temp = node.next;
            node.next = res;
            res = node;
            node = temp;
        }
        return res;
    }
}
