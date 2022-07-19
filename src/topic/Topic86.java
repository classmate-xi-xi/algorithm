package topic;

/**
 * @author: ywx
 * @description 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置
 * @Date: 2022/07/19
 */

public class Topic86 {
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

    public ListNode partition(ListNode head, int x) {
        // p1, p2 指针负责生成结果链表
        // dummy1 小于x的链表头结点
        ListNode dummy1 = new ListNode(-1), p1 = dummy1;
        // dummy2 大于x的链表头结点
        ListNode dummy2 = new ListNode(-1), p2 = dummy2;
        // p 负责遍历原链表，类似合并两个有序链表的逻辑
        // 这里是将一个链表分解成两个链表
        ListNode p = head;
        while (p != null) {
            if (p.val >= x) {
                p2.next = p;
                p2 = p2.next;
            } else {
                p1.next = p;
                p1 = p1.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(12);
        listNode.next = listNode1;
        ListNode listNode2 = new ListNode(11);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(4);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(3);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(2);
        listNode4.next = listNode5;

        new Topic86().partition(listNode, 5);
    }
}
