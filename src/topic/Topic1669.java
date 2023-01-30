package topic;

/**
 * @author: ywx
 * @description
 * @Date: 2023/01/30
 */

public class Topic1669 {
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

    /**
     * 解释：我们删除 list1 中下标为 3 和 4 的两个节点，并将 list2 接在该位置
     *
     * @param list1 list1 = [0,1,2,3,4,5]
     * @param a     a = 3
     * @param b     b = 4
     * @param list2 list2 = [1000000,1000001,1000002]
     * @return [0, 1, 2, 1000000, 1000001, 1000002, 5]
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode aList = list1, bList = list1;
        while (--a > 0) {
            aList = aList.next;
        }
        while (b-- > 0) {
            bList = bList.next;
        }
        aList.next = list2;
        while (aList.next != null) {
            aList = aList.next;
        }
        aList.next = bList.next;
        bList.next = null;
        return list1;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        ListNode b = new ListNode(1000000);
        ListNode b2 = new ListNode(1000001);
        ListNode b3 = new ListNode(1000002);
        b.next = b2;
        b2.next = b3;
        new Topic1669().mergeInBetween(a, 3, 4, b);
    }
}
